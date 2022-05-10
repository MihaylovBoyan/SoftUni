package com.company.Workshop;

public class DollsCommand implements Command{

    private Toys toys;

    public DollsCommand(Toys toys) {
        this.toys = toys;
    }

    @Override
    public void execute() {
        toys.getDoll();
    }
}
