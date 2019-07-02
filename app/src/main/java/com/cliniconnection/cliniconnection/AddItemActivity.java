package com.cliniconnection.cliniconnection;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cliniconnection.cliniconnection.DataBase.AppDatabase;
import com.cliniconnection.cliniconnection.DataBase.ToDoSessions.TodoListItem;

public class AddItemActivity extends AppCompatActivity {

    EditText todo;
    EditText time;
    Button button;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"production")
                .build();

        todo = (EditText) findViewById(R.id.name);
        time = (EditText) findViewById(R.id.time);
        button = (Button)findViewById(R.id.button);


        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"production")
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!todo.getText().toString().equals("") && !time.getText().toString().equals("")){

                    final TodoListItem todoListItem= new TodoListItem(todo.getText().toString(),time.getText().toString());
                    //save the item before leaving the activity


                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            db.databaseInterface().insertAll(todoListItem);
                        }
                    });


                    Intent i = new Intent(AddItemActivity.this,AMain.class);
                    startActivity(i);

                    finish();
                }
            }
        });
    }
}