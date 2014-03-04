package com.example.AndroidTest;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private int score;

    User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setScore(int score) {
        this.score=score;
    }
    public int getScore() {
        return score;
    }
}