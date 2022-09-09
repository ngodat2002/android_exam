package com.example.myapplication.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.Feedback;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter{
    Activity activity;
    List<Feedback> feedbackList;

    public FeedbackAdapter(Activity activity, List<Feedback> feedbackList) {
        this.activity = activity;
        this.feedbackList = feedbackList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_feedback,
                parent, false);
        FeedbackHolder holder = new FeedbackHolder(itemView);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int
            position) {
        FeedbackHolder vh = (FeedbackHolder) holder;
        final Feedback model = feedbackList.get(position);
        vh.tvID.setText(model.id + "");
        vh.tvFullname.setText(model.fullname);
        vh.tvEmail.setText(model.email);
        vh.tvFavorite.setText(model.favorite);
    }
    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public class FeedbackHolder extends RecyclerView.ViewHolder {
        TextView tvFullname, tvEmail, tvFavorite,tvID;
        Button btUpdate;

        public FeedbackHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvFullname = itemView.findViewById(R.id.tvFullname);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvFavorite = itemView.findViewById(R.id.tvFavorite);
        }
    }
}
