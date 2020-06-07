package com.basic.myandroidcompanion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     Button topics,notes,projects,homework;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topics=findViewById(R.id.bt_topics);
        notes=findViewById(R.id.bt_notes);
        projects=findViewById(R.id.bt_projects);
        homework=findViewById(R.id.bt_homework);

       topics.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), TopicsCovered_activity.class);
               startActivity(intent);
           }
           });

       notes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= new Intent(getApplicationContext(),Notes_activity.class);
               startActivity(intent);
           }
       });
       projects.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent= new Intent(getApplicationContext(),Projects_activity.class);
                       startActivity(intent);
                   }
               });
       homework.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent= new Intent(getApplicationContext(),Homework_activity.class);
                       startActivity(intent);
                   }
               });




        }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("EXIT:");
        builder.setMessage("Do You Want To Exit?");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}
