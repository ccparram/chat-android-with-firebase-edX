package com.example.ccparram.androidchat.login;

import com.example.ccparram.androidchat.login.event.LoginEvent;

public interface LoginPresenter {

    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent loginEvent);
}
