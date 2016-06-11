package com.example.ccparram.androidchat;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.editTxt_email)
    EditText editTxtEmail;
    @BindView(R.id.editTxt_password)
    EditText editTxtPassword;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_signin)
    public void handledSingin() {
    }

    @OnClick(R.id.btn_signup)
    public void handledSingup() {
    }
}
