package main.java.by.vasiliuk.command;

import main.java.by.vasiliuk.command.impl.GetAllAdvertsCommand;
import main.java.by.vasiliuk.command.impl.LoginCommand;
import main.java.by.vasiliuk.command.impl.NewAdvertCommand;

public enum CommandType {
    ALL_ADVERTS(new GetAllAdvertsCommand()),
    LOGIN(new LoginCommand()),
    NEW_ADVERT(new NewAdvertCommand())
    ;
    CommandType(Command command) {
        this.command = command;
    }
    private Command command;

    public Command getCommand() {
        return command;
    }
}
