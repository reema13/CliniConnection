package com.cliniconnection.cliniconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPatient extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.cliniconnection.cliniconnection.REPLY";

    private EditText pName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient);
        pName = findViewById(R.id.patient_name);

        final Button button = findViewById(R.id.save_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(pName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String patient = pName.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, patient);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
