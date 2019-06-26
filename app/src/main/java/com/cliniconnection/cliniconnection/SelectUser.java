package com.cliniconnection.cliniconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectUser extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectuser);


        b1=(Button)findViewById(R.id.docrorpage);
        b2=(Button)findViewById(R.id.patientpage);



        b1.setOnClickListener(this);
        b2.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.docrorpage){
            Intent user1 = new Intent(SelectUser.this, SeeLogs.class);
            startActivity(user1);
        }
        else if(v.getId()==R.id.patientpage){
            Intent user2 = new Intent(SelectUser.this, ConnectwithDoctor.class);
            startActivity(user2);
        }
    }
}
