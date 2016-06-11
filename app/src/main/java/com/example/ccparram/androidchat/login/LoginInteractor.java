package com.example.ccparram.androidchat.login;

public interface LoginInteractor {

    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
