package com.example.prabhsandroidlab;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "message")
    protected String message;
    @ColumnInfo(name = "TimeSent")
    protected String timeSent;
    @ColumnInfo(name = "SendOrReceive")
    protected int sendOrReceive;
    boolean isSentButton;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public void setSentButton(boolean sentButton) {
        isSentButton = sentButton;
    }
    public String getMessage() {
        return message;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public boolean isSentButton() {
        return isSentButton;
    }

    public ChatMessage(){

    }
    public ChatMessage(String m, String t, boolean sent) {
        message = m;
        timeSent = t;
        isSentButton = sent;
    }

}