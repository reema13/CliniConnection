package com.cliniconnection.cliniconnection;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cliniconnection.cliniconnection.DataBase.Patient.Patient;
import com.cliniconnection.cliniconnection.DataBase.PatientDataBase;


public class NewPatient extends AppCompatActivity {



    private EditText pName;
    private EditText pAge;
    private EditText pPhone;
    private EditText pStatus;
    private EditText pMed;
    private EditText pMore;
    PatientDataBase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient);

        db = Room.databaseBuilder(getApplicationContext(), PatientDataBase.class,"patient")
                .build();

        pName = findViewById(R.id.patient_name);
        pAge = findViewById(R.id.patient_age);
        pPhone = findViewById(R.id.input_mobile);
        pStatus = findViewById(R.id.patient_status);
        pMed = findViewById(R.id.patient_meds);
        pMore = findViewById(R.id.more_info);

        final PatientDataBase db = Room.databaseBuilder(getApplicationContext(), PatientDataBase.class,"patient")
                .build();

        final Button button = findViewById(R.id.save_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!pName.getText().toString().equals("") && !pStatus.getText().toString().equals("")){

                    final Patient patient= new Patient(pName.getText().toString(),pStatus.getText().toString());
                    //save the item before leaving the activity


                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            db.patientDAO().insert(patient);
                        }
                    });


                    Intent i = new Intent(NewPatient.this,EnterInfo.class);
                    startActivity(i);

                    finish();
                }

            }
        });
    }
}
