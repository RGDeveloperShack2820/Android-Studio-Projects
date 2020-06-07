package com.basic.myandroidcompanion;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TopicsCovered_activity extends AppCompatActivity {

    EditText topics,et_search;
    LinearLayout ll_search;
    Button bt_search,bt_search_close;
    static String tp;
    String stp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_covered_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_topics);
        topics=findViewById(R.id.et_topics);
        ll_search=findViewById(R.id.ll_search);
        et_search=findViewById(R.id.et_search);
        bt_search=findViewById(R.id.bt_search);
        bt_search_close=findViewById(R.id.bt_search_close);

        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        stp= getsaved.getString("topics",tp);

        if (tp!=null)
       {
           topics.setText(tp);
       }

       else {
           topics.setText(stp);
       }


       bt_search_close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ll_search.setVisibility(View.GONE);
           }
       });
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


            stp=topics.getText().toString();

            SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor=saving.edit();
            editor.putString("topics",stp);
            editor.apply();


            Toast.makeText(TopicsCovered_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();
            return true;
        }
         if (id==R.id.action_search){

            ll_search.setVisibility(View.VISIBLE);

        }


        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        tp=topics.getText().toString();
    }
}



