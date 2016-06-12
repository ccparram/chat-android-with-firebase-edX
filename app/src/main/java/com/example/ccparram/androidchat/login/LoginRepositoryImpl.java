package com.example.ccparram.androidchat.login;

import android.util.Log;

import com.example.ccparram.androidchat.domain.FirebaseHelper;

public class LoginRepositoryImpl implements LoginRepository{

    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getIstance();
    }

    @Override
    public void signUp(String email, String password) {
        Log.e("LoginRepositoryImpl", "signup");
    }

    @Override
    public void signIn(String email, String password) {
        Log.e("LoginRepositoryImpl", "signin");
    }

    @Override
    public void checkSession() {
        Log.e("LoginRepositoryImpl", "check session");
    }
}
