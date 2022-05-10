package com.company.Workshop;

import com.company.command.RemoteController;

public class Santa {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public Santa setCommand(Command command) {
        this.command = command;
        return this;
    }

    public void makeOrder() {
        if (command == null) {
            System.out.println("No command set");
        }
        this.command.execute();
    }

}
