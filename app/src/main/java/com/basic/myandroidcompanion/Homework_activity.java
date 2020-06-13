package com.basic.myandroidcompanion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class Homework_activity extends AppCompatActivity {

    EditText homework;
    EditText  et_search;
    ScrollView scroll_homework;
    LinearLayout ll_search;
    Button bt_search_close;
    String shw="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_topics);


        scroll_homework=findViewById(R.id.scroll_homework);
        homework=findViewById(R.id.et_homework);
        ll_search=findViewById(R.id.ll_search);
        et_search=findViewById(R.id.et_search);
        bt_search_close=findViewById(R.id.bt_search_close);

        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        shw= getsaved.getString("homework","");
        if (!shw.isEmpty())
        {
            homework.setText(shw);

        }




        bt_search_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ll_search.setVisibility(View.GONE);
            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int search_index,search_line;

                search_index=shw.indexOf(et_search.getText().toString());
                search_line=homework.getLayout().getLineForOffset(search_index);

                scroll_homework.scrollTo(0,homework.getLayout().getLineTop(search_line));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        homework.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                shw=homework.getText().toString();

                SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor=saving.edit();
                editor.putString("homework",shw);
                editor.apply();

            }

            @Override
            public void afterTextChanged(Editable s) {

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

        if (id==R.id.action_search){


            ll_search.setVisibility(View.VISIBLE);
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        shw=homework.getText().toString();

        SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=saving.edit();
        editor.putString("homework",shw);
        editor.apply();
        Toast.makeText(Homework_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        shw=homework.getText().toString();

        SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=saving.edit();
        editor.putString("homework",shw);
        editor.apply();
        Toast.makeText(Homework_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();


    }


}
