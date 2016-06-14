package com.example.ccparram.androidchat.contacList;

public interface ContactListRepository {

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void destroyListener();
    void suscribeToContactListEvents();
    void unsuscribeToContactListEvents();
    void changeConnectionStatus(boolean online);
}
