package com.example.ccparram.androidchat.contacList;

public interface ContactListInteractor {

    void suscribe();
    void unsuscribe();
    void destroyListener();
    void removeContact(String email);
}
