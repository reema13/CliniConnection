package com.cliniconnection.cliniconnection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConnectwithDoctor extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_with_doctor);

        Button b1,b2,b3,b4,b5;
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1){
            Intent makecall = new Intent(ConnectwithDoctor.this, MakeCall.class);

            startActivity(makecall);
        }


        if(v.getId()==R.id.button2){
            Intent message = new Intent(ConnectwithDoctor.this, TextMessage.class);

            startActivity(message);
        }

        if(v.getId()==R.id.button3){
            Intent setalarm = new Intent(ConnectwithDoctor.this, SetAlarm.class);

            startActivity(setalarm);
        }
        if(v.getId()==R.id.button4){
            Intent chat = new Intent(ConnectwithDoctor.this, Register.class);

            startActivity(chat);
        }

        if(v.getId()==R.id.button5){
            startActivity(new Intent(ConnectwithDoctor.this, LoginActivity.class));
        }
    }
}
