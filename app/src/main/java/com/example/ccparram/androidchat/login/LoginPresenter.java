package com.example.ccparram.androidchat.login;

public interface LoginPresenter {

    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
