package com.company.command;

public class RemoteController {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public RemoteController setCommand(Command command) {
        this.command = command;
        return this;
    }

    public void pressButton() {
        if (command == null) {
            System.out.println("No command set");
        }
        this.command.execute();
    }

}
