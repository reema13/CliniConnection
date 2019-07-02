package com.cliniconnection.cliniconnection.DataBase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.cliniconnection.cliniconnection.DataBase.ToDoSessions.DatabaseInterface;
import com.cliniconnection.cliniconnection.DataBase.ToDoSessions.TodoListItem;

@Database(entities = {TodoListItem.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DatabaseInterface databaseInterface();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}