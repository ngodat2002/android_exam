package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Feedback.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public abstract FeedbackDao feedbackDao();
    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "Feedback.db").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}