package com.aaron.jcpennyprepassignment.Events;

/**
 * Created by aaron on 10/12/17.
 */

public class MessageEvent {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageEvent(String message) {

        this.message = message;
    }
}
