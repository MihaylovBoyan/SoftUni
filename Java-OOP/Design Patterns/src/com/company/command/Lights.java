package com.company.command;

public class Lights {

    private boolean lightsOn;

    public void turnOn(){
        lightsOn = true;
        System.out.println("Lights are on");
    }

    public void turnOff(){
        lightsOn = false;
        System.out.println("Lights are off");

    }


}
