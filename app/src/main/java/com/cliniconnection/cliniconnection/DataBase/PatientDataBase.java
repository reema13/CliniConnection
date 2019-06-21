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
import com.cliniconnection.cliniconnection.DataBase.Patient.PatientDao;
import com.cliniconnection.cliniconnection.DataBase.Payment.Payment;
import com.cliniconnection.cliniconnection.DataBase.Session.Session;


@Database(entities = {
        Patient.class, Doctor.class, Medication.class, Payment.class, Session.class

}
        ,version = 1)

public abstract class PatientDataBase extends RoomDatabase {

    private static PatientDataBase instance;
    public abstract PatientDao patientDAO();


    public static synchronized PatientDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    PatientDataBase.class,"patient_database")
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


        private PatientDao patientDAO;

        private PopulateDbAsyncTask(PatientDataBase db){


            patientDAO=instance.patientDAO();

        }



        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }

}


