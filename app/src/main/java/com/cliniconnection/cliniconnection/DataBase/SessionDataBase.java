package com.cliniconnection.cliniconnection.DataBase;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.cliniconnection.cliniconnection.DataBase.Doctor.Doctor;
import com.cliniconnection.cliniconnection.DataBase.Medication.Medication;
import com.cliniconnection.cliniconnection.DataBase.Patient.Patient;
import com.cliniconnection.cliniconnection.DataBase.Payment.Payment;
import com.cliniconnection.cliniconnection.DataBase.Session.Session;
import com.cliniconnection.cliniconnection.DataBase.Session.SessionDao;


@Database(entities = {
        Session.class, Patient.class, Payment.class, Doctor.class, Medication.class

}
        ,version = 1)

public abstract class SessionDataBase extends RoomDatabase {

    private static SessionDataBase instance;
    public abstract SessionDao sessionDAO();


    public static synchronized SessionDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    SessionDataBase.class,"session_database")
                    .fallbackToDestructiveMigration().
                            addCallback(roomCallback).
                            build();
        }
        return instance;
    }




    //CallBack---------------------------
    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    //AsyncTask ------------------------------------------------------------
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {


        private SessionDao sessionDAO;

        private PopulateDbAsyncTask(SessionDataBase db){


            sessionDAO=instance.sessionDAO();

        }



        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }


}
