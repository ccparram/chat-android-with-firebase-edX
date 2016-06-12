package com.example.ccparram.androidchat.lib;

public class GreenRobotEventBus implements EventBus{

    org.greenrobot.eventbus.EventBus eventBus;

    private static final class SingletonHolder{
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private GreenRobotEventBus() {
        this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object suscriber) {
        eventBus.register(suscriber);
    }

    @Override
    public void unregister(Object suscriber) {
        eventBus.unregister(suscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
