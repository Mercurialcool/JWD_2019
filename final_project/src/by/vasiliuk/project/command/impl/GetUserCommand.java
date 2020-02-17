package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.model.User;
import by.vasiliuk.project.model.UserTo;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static by.vasiliuk.project.command.JspPath.LOGIN_PAGE;

public class GetUserCommand implements Command {

    private UserTo userTo;
    private long id;

    public GetUserCommand(long id) {
        this.id = id;
    }

    public UserTo getUser() {
        return userTo;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserTo userTo;
        UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();
        Optional<User> userOptional = null;
        try {
            userOptional = userServiceImpl.findUser(id);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        if(userOptional.isPresent()){
            User user = userOptional.get();
            userTo = new UserTo(user.getId(), user.getUsername(), user.getRating());
        } else {
            //throw exception
        }
        return LOGIN_PAGE;
    }
}
