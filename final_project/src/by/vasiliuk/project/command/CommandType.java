package by.vasiliuk.project.command;

import by.vasiliuk.project.command.impl.*;

public enum CommandType {
    ALL_ADVERTS(new GetAllAdvertsCommand()),
    LOGIN(new LoginCommand()),
    NEW_ADVERT(new NewAdvertCommand()),
    ADVERTS_BY_SECTION_ID(new GetAdvertsBySectionIdCommand()),
    DEFAULT(new DefaultCommand()),
    REGISTER(new RegisterUserCommand()),
    //GET_USER(new GetUserCommand()),
    ;
    CommandType(Command command) {
        this.command = command;
    }
    private Command command;

    public Command getCommand() {
        return command;
    }
}
