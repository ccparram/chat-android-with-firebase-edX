package com.example.ccparram.androidchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.ccparram.androidchat.R;
import com.example.ccparram.androidchat.contacList.ContacListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{


    @BindView(R.id.editTxt_email)
    EditText inputEmail;
    @BindView(R.id.editTxt_password)
    EditText inputPassword;
    @BindView(R.id.wrapper_password)
    TextInputLayout wrapperPassword;
    @BindView(R.id.btn_signin)
    Button btnSignin;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.layout_buttons)
    LinearLayout layoutButtons;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.layout_main_container)
    RelativeLayout layoutMainContainer;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.checkForAuthenticatedUser();
    }

    @OnClick(R.id.btn_signin)
    public void handledSingin() {
    }

    @OnClick(R.id.btn_signup)
    public void handledSingup() {
    }

    @Override
    public void enabledInputs() {
        setInput(true);
    }

    @Override
    public void disableInputs() {
        setInput(false);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgessBar() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_signup)
    @Override
    public void handledSignUp() {
        loginPresenter.registerNewUser(inputEmail.getText().toString(),
                                        inputPassword.getText().toString());
    }

    @OnClick(R.id.btn_signin)
    @Override
    public void handledSignIn() {
        loginPresenter.validateLogin(inputEmail.getText().toString(),
                inputPassword.getText().toString());
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ContacListActivity.class));
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        inputPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(layoutMainContainer, R.string.login_notice_message_signup, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        inputPassword.setError(msgError);
    }

    private void setInput(boolean enabled){
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        btnSignup.setEnabled(enabled);
        btnSignin.setEnabled(enabled);
    }
}
