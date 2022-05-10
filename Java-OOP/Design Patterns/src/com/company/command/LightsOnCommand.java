package com.company.command;

public class LightsOnCommand implements Command{

    private Lights lights;

    public LightsOnCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.turnOn();
    }
}
