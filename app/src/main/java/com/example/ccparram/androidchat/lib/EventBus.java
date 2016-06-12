package com.example.ccparram.androidchat.lib;

public interface EventBus {

    void register(Object suscriber);
    void unregister(Object suscriber);
    void post(Object suscriber);
}
