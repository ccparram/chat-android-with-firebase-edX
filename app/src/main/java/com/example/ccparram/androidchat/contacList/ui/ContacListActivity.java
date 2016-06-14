package com.example.ccparram.androidchat.contacList.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ccparram.androidchat.R;
import com.example.ccparram.androidchat.contacList.ContacListPresenter;
import com.example.ccparram.androidchat.entities.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContacListActivity extends AppCompatActivity implements ContactListView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerViewContacts)
    RecyclerView recyclerViewContacts;

    private ContacListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contac_list);
        ButterKnife.bind(this);

        presenter.onCreate();
        toolbar.setTitle(presenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @OnClick(R.id.fab)
    public void addContact() {
    }

    @Override
    public void onContactAdded(User user) {

    }

    @Override
    public void onContactChanged(User user) {

    }

    @Override
    public void onContactRemoved(User user) {

    }
}
