package by.vasiliuk.project.command;

import by.vasiliuk.project.command.impl.GetAllAdvertsCommand;
import by.vasiliuk.project.command.impl.LoginCommand;
import by.vasiliuk.project.command.impl.NewAdvertCommand;

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
