package com.huntech.pvs.view.request;

import java.io.Serializable;

public class MessageData implements Serializable{

    private Message message;
    private String type;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    //    { message:{cotent:message,from:"userid",to:to,time:Daee()},type:"message" }
}
