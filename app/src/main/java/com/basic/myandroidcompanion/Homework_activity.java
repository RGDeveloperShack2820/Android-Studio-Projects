package com.basic.myandroidcompanion;

import android.content.Intent;
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

public class Homework_activity extends AppCompatActivity {

    String str_data_shw="";
    EditText homework;
    static String hw="";
    String shw="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_homework);
        homework=findViewById(R.id.et_homework);

        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        shw= getsaved.getString("homework",shw);

        Intent intent=getIntent();
        if (intent.hasExtra("data_topic"))
        str_data_shw= intent.getStringExtra("data_topic");



        homework.setText(shw+str_data_shw);

//        if (hw!=null)
//        {
//            homework.setText(hw);
//        }
//
//        else {
//            homework.setText(shw);
//        }


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

            shw=homework.getText().toString();

            SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor=saving.edit();
            editor.putString("homework",shw);
            editor.apply();

            Toast.makeText(getApplicationContext(), "Content Saved", Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        hw=homework.getText().toString();
    }


}
