package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FeedbackDao {
    @Insert
    long insertFeedback(Feedback feedback);
    @Query("Select * from feedbacks")
    List<Feedback> getAllFeedback();
}