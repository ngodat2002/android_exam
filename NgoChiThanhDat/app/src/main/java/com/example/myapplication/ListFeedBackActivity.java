package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.FeedbackAdapter;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.Feedback;

import java.util.List;

public class ListFeedBackActivity extends AppCompatActivity {
    RecyclerView rvFeedback;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_feed_back);
        db = AppDatabase.getAppDatabase(this);
        List<Feedback> list = db.feedbackDao().getAllFeedback();
        FeedbackAdapter adapter = new FeedbackAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        rvFeedback = findViewById(R.id.rvFeedback);
        rvFeedback.setLayoutManager(layoutManager);
        rvFeedback.setAdapter(adapter);
    }
}