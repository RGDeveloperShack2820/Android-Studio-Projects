package com.basic.myandroidcompanion;

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

public class Projects_activity extends AppCompatActivity {

    EditText projects;
    EditText  et_search;
    ScrollView scroll_projects;
    LinearLayout ll_search;
    Button bt_search_close;
    String spj="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_topics);


        scroll_projects=findViewById(R.id.scroll_projects);
        projects=findViewById(R.id.et_projects);
        ll_search=findViewById(R.id.ll_search);
        et_search=findViewById(R.id.et_search);
        bt_search_close=findViewById(R.id.bt_search_close);

        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        spj= getsaved.getString("projects","");
        if (!spj.isEmpty())
        {
            projects.setText(spj);

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

                search_index=spj.indexOf(et_search.getText().toString());
                search_line=projects.getLayout().getLineForOffset(search_index);

                scroll_projects.scrollTo(0,projects.getLayout().getLineTop(search_line));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        projects.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                spj=projects.getText().toString();

                SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor=saving.edit();
                editor.putString("projects",spj);
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
        spj=projects.getText().toString();

        SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=saving.edit();
        editor.putString("projects",spj);
        editor.apply();
        Toast.makeText(Projects_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        spj=projects.getText().toString();

        SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=saving.edit();
        editor.putString("projects",spj);
        editor.apply();
        Toast.makeText(Projects_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();

    }
  }
