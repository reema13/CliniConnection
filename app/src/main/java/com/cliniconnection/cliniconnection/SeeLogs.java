package com.cliniconnection.cliniconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SeeLogs extends AppCompatActivity {
    Button _log,_meds, _chat, _info, _session, _seelogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seelogs);


        _chat = findViewById(R.id.chat);
        _info = findViewById(R.id.info);
        _meds = findViewById(R.id.meds);
        _seelogs = findViewById(R.id.button5);
        _session = findViewById(R.id.sessionbtn);
        _log = findViewById(R.id.logs);


        _log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}