package com.huntech.pvs.view.request;

import java.io.Serializable;

public class Message implements Serializable{
    private String content;
    private String from;
    private String to;
    private String time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Message() {
    }

    public Message(String content, String from, String to, String time) {
        this.content = content;
        this.from = from;
        this.to = to;
        this.time = time;
    }
}
