package com.company.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Observable{

    private List<Observer> observers;
    private String topic;

    public Topic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        observer.setTopic(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        observer.setTopic(null);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update();
        }

    }

    @Override
    public String getUpdate() {
        return topic;
    }

    public Topic setTopic(String topic) {
        this.topic = topic;
        notifyObservers();
        return this;
    }
}
