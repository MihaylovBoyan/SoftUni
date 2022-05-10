package com.company.Workshop;

public class BikesCommand implements Command{

    private Toys toys;

    public BikesCommand(Toys toys) {
        this.toys = toys;
    }

    @Override
    public void execute() {
        toys.getBike();
    }
}
