package com.cliniconnection.cliniconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SeeLogs extends AppCompatActivity {
    Button _meds, _chat, _info, _session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seelogs);


        _chat = findViewById(R.id.chat);
        _info = findViewById(R.id.info);
        _meds = findViewById(R.id.meds);
        _session = findViewById(R.id.sessionbtn);



        _info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeeLogs.this,EnterInfo.class));
            }
        });

        _chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeeLogs.this, Chat.class));
            }
        });

        _meds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(SeeLogs.this, EnterMed.class));
            }
        });

        _session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeeLogs.this, AMain.class));
            }
        });

    }
}