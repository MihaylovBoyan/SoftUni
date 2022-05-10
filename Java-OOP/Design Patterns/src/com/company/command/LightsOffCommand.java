package com.company.command;

public class LightsOffCommand implements Command {

    private Lights lights;

    public LightsOffCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.turnOff();
    }
}
