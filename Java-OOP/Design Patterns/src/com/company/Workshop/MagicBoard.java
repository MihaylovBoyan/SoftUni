package com.company.Workshop;

import com.company.observer.Topic;

import java.util.ArrayList;
import java.util.List;

public class MagicBoard implements Subject {

    private Toy toy;
    private String magicWords = "";
    private List<Observer> observers;

    public MagicBoard() {
        observers = new ArrayList<>();
    }

    public String getMagicWords() {
        return magicWords;
    }

//    public void setMagicWords(String magicWords) {
//        this.magicWords = magicWords;
//    }

    public Toy createToy() {

        if (magicWords.equals("bike")) {
            return new Bike();
        } else {
            return new Doll();
        }

    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        observer.setMagicWords(this.magicWords);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String getUpdate() {
        return this.magicWords;
    }

    public MagicBoard setMagicWords(String magicWords) {
        this.magicWords = magicWords;
        notifyObservers();
        return this;
    }
}
