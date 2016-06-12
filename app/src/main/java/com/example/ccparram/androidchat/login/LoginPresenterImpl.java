package com.example.ccparram.androidchat.login;

import com.example.ccparram.androidchat.lib.EventBus;
import com.example.ccparram.androidchat.lib.GreenRobotEventBus;
import com.example.ccparram.androidchat.login.event.LoginEvent;
import com.example.ccparram.androidchat.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

public class LoginPresenterImpl implements LoginPresenter {

    private EventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unregister(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if(loginView != null){
            loginView.disableInputs();
            loginView.showProgressBar();
        }

        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if(loginView != null){
            loginView.disableInputs();
            loginView.showProgressBar();
        }

        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if(loginView != null){
            loginView.disableInputs();
            loginView.showProgressBar();
        }

        loginInteractor.doSignUp(email, password);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent loginEvent) {
        switch (loginEvent.getEventType()){
            case LoginEvent.ON_SIGN_IN_SUCCESS:
                onSignInSuccess();
                break;

            case LoginEvent.ON_SIGN_UP_SUCCESS:
                onSignUpSuccess();
                break;

            case LoginEvent.ON_SIGN_IN_ERROR:
                onSignInError(loginEvent.getErrorMessage());
            break;

            case LoginEvent.ON_SIGN_UP_ERROR:
                onSignUpError(loginEvent.getErrorMessage());
                break;

            case LoginEvent.ON_FAILED_TO_RECOVER_SESSION:
                onFailedToRecoverSession();
                break;
        }
    }

    private void onSignInSuccess(){
        if(loginView != null){
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(){
        if(loginView != null){
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if(loginView != null){
            loginView.hideProgessBar();
            loginView.enabledInputs();
            loginView.loginError(error);
        }

    }

    private void onSignUpError(String error){
        if(loginView != null){
            loginView.hideProgessBar();
            loginView.enabledInputs();
            loginView.newUserError(error);
        }
    }

    private void onFailedToRecoverSession() {
        if(loginView != null){
            loginView.hideProgessBar();
            loginView.enabledInputs();
        }
    }
}
