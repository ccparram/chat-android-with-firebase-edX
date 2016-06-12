package com.example.ccparram.androidchat.login.event;

public class LoginEvent {

    public final static int ON_SIGN_IN_ERROR = 0;
    public final static int ON_SIGN_UP_ERROR = 1;
    public final static int ON_SIGN_IN_SUCCESS = 2;
    public final static int ON_SIGN_UP_SUCCESS = 3;
    public final static int ON_FAILED_TO_RECOVER_SESSION = 4;

    private int eventType;
    private String errorMessage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
