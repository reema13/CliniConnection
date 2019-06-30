package com.cliniconnection.cliniconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class EnterInfo extends AppCompatActivity {
    private static final String TAG = "EnterInfo";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    FloatingActionButton fab;

 //   ArrayList<String> users;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_patient_info);

        recyclerView = findViewById(R.id.recycler_view);

        /*users = new ArrayList<>();//to be modified
        for (int i = 0; i<10; i++){

            users.add("Reema #"+ i);

        }*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

   //     adapter = new UserAdapter(users); //to pass data here

        recyclerView.setAdapter(adapter);

        fab=findViewById(R.id.floatfab);
         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //Log.d(TAG, "onClick: pressed!");

                 startActivity(new Intent(EnterInfo.this,AddBasic.class));

             }
         });
    }
}
