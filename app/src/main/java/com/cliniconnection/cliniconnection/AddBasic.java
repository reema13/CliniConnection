package com.cliniconnection.cliniconnection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBasic extends AppCompatActivity {

    EditText pName, pAdress, pStatus, pMeds, PNumber, pMore;
    Button savebtn, cancelbtn;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_basic);

        pName = findViewById(R.id.patient_name);
        pAdress = findViewById(R.id.patient_address);
        pMeds = findViewById(R.id.patient_meds);
        pMore = findViewById(R.id.more_info);
        pStatus = findViewById(R.id.patient_status);
        PNumber = findViewById(R.id.input_mobile);

        savebtn =findViewById(R.id.save_btn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saving to database

            }
        });
        cancelbtn =findViewById(R.id.cancel_btn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
