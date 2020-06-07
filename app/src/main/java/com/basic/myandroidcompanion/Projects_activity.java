package com.basic.myandroidcompanion;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Projects_activity extends AppCompatActivity {

    EditText projects;
    static String pj;
    String spj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_projects);
        projects=findViewById(R.id.et_projects);
        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        spj= getsaved.getString("projects",pj);
        if (pj!=null)
        {
            projects.setText(pj);
        }

        else {
            projects.setText(spj);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();
        if (id == R.id.action_save) {

            spj=projects.getText().toString();

            SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor=saving.edit();
            editor.putString("projects",spj);
            editor.apply();

            Toast.makeText(getApplicationContext(), "Content Saved", Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        pj=projects.getText().toString();
    }
  }
