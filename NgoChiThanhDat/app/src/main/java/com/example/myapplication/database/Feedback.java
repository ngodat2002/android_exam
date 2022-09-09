package com.example.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "feedbacks")
public class Feedback {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "fullname")
    public String fullname;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "favorite")
    public String favorite;
    @ColumnInfo(name = "des")
    public String des;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
