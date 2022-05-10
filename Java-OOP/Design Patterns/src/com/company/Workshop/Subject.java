package com.company.Workshop;


public interface Subject {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();

    String getUpdate();
}
