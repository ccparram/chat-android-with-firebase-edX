package com.example.ccparram.androidchat.contacList.ui;

import com.example.ccparram.androidchat.entities.User;

public interface ContactListView {

    void onContactAdded(User user);

    void onContactChanged(User user);

    void onContactRemoved(User user);
}