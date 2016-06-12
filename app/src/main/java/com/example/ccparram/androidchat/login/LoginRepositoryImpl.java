package com.example.ccparram.androidchat.login;

import com.example.ccparram.androidchat.domain.FirebaseHelper;
import com.example.ccparram.androidchat.lib.EventBus;
import com.example.ccparram.androidchat.lib.GreenRobotEventBus;
import com.example.ccparram.androidchat.login.event.LoginEvent;

public class LoginRepositoryImpl implements LoginRepository{

    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getIstance();
    }

    @Override
    public void signUp(String email, String password){
        postEvent(LoginEvent.ON_SIGN_UP_SUCCESS);
    }

    @Override
    public void signIn(String email, String password) {
        postEvent(LoginEvent.ON_SIGN_IN_SUCCESS);
    }

    @Override
    public void checkSession() {
        postEvent(LoginEvent.ON_FAILED_TO_RECOVER_SESSION);
    }

    private void postEvent(int type, String errorMessage){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null){
            loginEvent.setErrorMessage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);

    }

    private void postEvent(int type){
        postEvent(type, null);
    }
}
