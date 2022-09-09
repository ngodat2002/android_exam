package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.adapter.FeedbackAdapter;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.Feedback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edFullname, edEmail, edDes;
    Spinner spinner;
    Button btSend;
    String favorite = "Front-End";
    CheckBox ckAgree;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        edFullname = findViewById(R.id.edFullname);
        edEmail = findViewById(R.id.edEmail);
        edDes = findViewById(R.id.edDes);
        ckAgree = findViewById(R.id.ck);
        spinner = findViewById(R.id.spinner);
        btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(this);
        String[] listFavorite = {"Front-End", "Back-End"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listFavorite);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i,
                                       long l) {
                Log.d("TAG", "onItemSelected: "+listFavorite[i]);
                favorite = listFavorite[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void onSendFeedback() {
        if (!validate()) {
            return;
        }
        Feedback feedback = new Feedback();
        feedback.fullname = edFullname.getText().toString();
        feedback.email = edEmail.getText().toString();
        feedback.des = edDes.getText().toString();
        feedback.favorite = favorite;
        long id = db.feedbackDao().insertFeedback(feedback);
        if (id > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        goToListFeedback();
    }
    private void goToListFeedback() {
        Intent intent = new Intent(this, ListFeedBackActivity.class);
        startActivity(intent);
    }
    private boolean validate() {
        String mes = null;
        if (edFullname.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập fullname";
        }else if (edFullname.getText().toString().trim().isEmpty()){
            mes = "Chưa nhập email";
        }
        else if (edDes.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập giới thiệu";
        }else if (!ckAgree.isChecked()) {
            mes = "Bạn phải đồng ý điều khoản";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSend:
                onSendFeedback();
                break;
            default:
                break;
        }
    }
}