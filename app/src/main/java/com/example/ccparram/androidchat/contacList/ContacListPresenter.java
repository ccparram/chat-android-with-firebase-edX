package com.example.ccparram.androidchat.contacList;

import com.example.ccparram.androidchat.contacList.events.ContactListEvent;

public interface ContacListPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removerContact(String email);
    void onEventMainThread(ContactListEvent event);
}
