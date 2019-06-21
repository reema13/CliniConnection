package com.cliniconnection.cliniconnection.DataBase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.cliniconnection.cliniconnection.DataBase.Doctor.Doctor;
import com.cliniconnection.cliniconnection.DataBase.Doctor.DoctorDao;
import com.cliniconnection.cliniconnection.DataBase.Medication.Medication;
import com.cliniconnection.cliniconnection.DataBase.Patient.Patient;
import com.cliniconnection.cliniconnection.DataBase.Payment.Payment;
import com.cliniconnection.cliniconnection.DataBase.Session.Session;


@Database(entities = {
        Doctor.class, Patient.class, Medication.class, Session.class, Payment.class

}
        ,version = 1)
//@TypeConverters({TimeConverter.class,OutBoundConverter.class})
public abstract class DoctorDataBase extends RoomDatabase {

    private static DoctorDataBase instance;
    public abstract DoctorDao doctorDAO();


    public static synchronized DoctorDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    DoctorDataBase.class,"doctor_database")
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


        private DoctorDao doctorDAO;

        private PopulateDbAsyncTask(DoctorDataBase db){


            doctorDAO=instance.doctorDAO();

        }



        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }

}

