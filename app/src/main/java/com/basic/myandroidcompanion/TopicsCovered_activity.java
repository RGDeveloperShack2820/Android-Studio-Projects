package com.basic.myandroidcompanion;


import android.content.SharedPreferences;
import android.os.Bundle;
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

public class TopicsCovered_activity extends AppCompatActivity   {

    EditText topics;
    EditText  et_search;

    ScrollView scroll_topics;
    LinearLayout ll_search;
    Button bt_search_close;
    String stp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_covered_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_action_toolbar_topics);


        scroll_topics=findViewById(R.id.scroll_topics);
        topics=findViewById(R.id.et_topics);
        ll_search=findViewById(R.id.ll_search);
        et_search=findViewById(R.id.et_search);
        bt_search_close=findViewById(R.id.bt_search_close);

        SharedPreferences getsaved=getSharedPreferences("data",MODE_PRIVATE);
        stp= getsaved.getString("topics","");
        if (!stp.isEmpty())
        {
            topics.setText(stp);

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

               search_index=stp.indexOf(et_search.getText().toString());
               search_line=topics.getLayout().getLineForOffset(search_index);

               scroll_topics.scrollTo(0,topics.getLayout().getLineTop(search_line));
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

       topics.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               stp=topics.getText().toString();

               SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
               SharedPreferences.Editor editor=saving.edit();
               editor.putString("topics",stp);
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
        stp=topics.getText().toString();

        SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=saving.edit();
        editor.putString("topics",stp);
        editor.apply();
        Toast.makeText(TopicsCovered_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        stp=topics.getText().toString();

        SharedPreferences saving=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=saving.edit();
        editor.putString("topics",stp);
        editor.apply();
        Toast.makeText(TopicsCovered_activity.this, "Content Saved", Toast.LENGTH_SHORT).show();

    }
}



