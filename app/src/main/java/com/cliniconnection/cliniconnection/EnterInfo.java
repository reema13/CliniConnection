package com.cliniconnection.cliniconnection;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cliniconnection.cliniconnection.DataBase.Patient.Patient;
import com.cliniconnection.cliniconnection.DataBase.PatientDataBase;

import java.util.ArrayList;
import java.util.List;


public class EnterInfo extends AppCompatActivity {
    private static final String TAG = "EnterInfo";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    FloatingActionButton fab;

List<Patient>patientList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_patient_info);

        final PatientDataBase db = Room.databaseBuilder(getApplicationContext(), PatientDataBase.class,"patient")
                .build();



        Runnable r = new Runnable(){
            @Override
            public void run() {
                patientList = (List<Patient>) db.patientDAO().getAll();
                recyclerView= (RecyclerView)findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
                adapter= new PatientListAdapter(patientList);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

            }
        };

        Thread newThread= new Thread(r);
        newThread.start();

        fab=(FloatingActionButton)findViewById(R.id.floatfab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnterInfo.this,NewPatient.class);
                startActivity(i);
                finish();
            }
        });
    }
}
