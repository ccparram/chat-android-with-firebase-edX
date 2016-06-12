package com.example.ccparram.androidchat.login;

import com.example.ccparram.androidchat.domain.FirebaseHelper;
import com.example.ccparram.androidchat.entities.User;
import com.example.ccparram.androidchat.lib.EventBus;
import com.example.ccparram.androidchat.lib.GreenRobotEventBus;
import com.example.ccparram.androidchat.login.event.LoginEvent;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class LoginRepositoryImpl implements LoginRepository{

    private FirebaseHelper helper;
    private Firebase dataReference;
    private Firebase myUserReference;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getIstance();
        this.dataReference = helper.getDataReference();
        this.myUserReference = helper.getMyUserReference();

    }

    @Override
    public void signUp(final String email, final String password){
        dataReference.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                postEvent(LoginEvent.ON_SIGN_UP_SUCCESS);
                signIn(email, password);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                postEvent(LoginEvent.ON_SIGN_UP_ERROR, firebaseError.getMessage());
            }
        });
    }

    @Override
    public void signIn(String email, String password) {
        dataReference.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                initSignIn();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                postEvent(LoginEvent.ON_SIGN_IN_ERROR, firebaseError.getMessage());
            }
        });
    }

    @Override
    public void checkSession() {
        if(dataReference.getAuth() != null){
            initSignIn();
        } else{
            postEvent(LoginEvent.ON_FAILED_TO_RECOVER_SESSION);
        }
    }

    private void initSignIn() {
        myUserReference = helper.getMyUserReference();
        myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);

                if(currentUser == null){
                    registerNewUser();
                }
                helper.changeUserConnectionStatus(User.ONLINE);
                postEvent(LoginEvent.ON_SIGN_IN_SUCCESS);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
    }

    private void registerNewUser() {
        String email = helper.getAuthUserEmail();
        if (email != null){
            User currentUser = new User();
            currentUser.setEmail(email);
            myUserReference.setValue(currentUser);
        }
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
