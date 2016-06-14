package com.example.ccparram.androidchat.contacList;

public interface ContactListSessionInteractor {

    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
