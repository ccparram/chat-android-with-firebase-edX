package com.example.ccparram.androidchat.login;

public interface LoginView {
    void enabledInputs();
    void disableInputs();
    void showProgressBar();
    void hideProgessBar();

    void handledSignUp();
    void handledSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}
