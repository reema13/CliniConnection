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
import com.cliniconnection.cliniconnection.DataBase.Medication.MedicationDao;
import com.cliniconnection.cliniconnection.DataBase.Patient.Patient;
import com.cliniconnection.cliniconnection.DataBase.Payment.Payment;
import com.cliniconnection.cliniconnection.DataBase.Session.Session;


@Database(entities = {
        Medication.class, Patient.class, Doctor.class, Session.class, Payment.class

}
        ,version = 1)

public abstract class MedicationDataBase extends RoomDatabase {

    private static MedicationDataBase instance;
    public abstract MedicationDao medicationDAO();


    public static synchronized MedicationDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    MedicationDataBase.class,"medication_database")
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


        private MedicationDao medicationDAO;

        private PopulateDbAsyncTask(MedicationDataBase db){


            medicationDAO=instance.medicationDAO();

        }



        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }


}
