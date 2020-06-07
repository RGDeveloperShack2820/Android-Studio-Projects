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

public class Notes_activity extends AppCompatActivity {

    EditText notes;
    static String nt;
    String snt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_notes);
        notes=findViewById(R.id.et_notes);
        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        snt= getsaved.getString("notes",snt);
        if (nt!=null)
        {
            notes.setText(nt);
        }

        else {
            notes.setText(snt);
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

            snt=notes.getText().toString();

            SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor=saving.edit();
            editor.putString("notes",snt);
            editor.apply();

            Toast.makeText(getApplicationContext(), "Content Saved", Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        nt=notes.getText().toString();
    }


}


