package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.service.impl.UserServiceImpl;
import by.vasiliuk.project.util.HashUtil;

import javax.servlet.http.HttpServletRequest;

import static by.vasiliuk.project.command.JspPath.LOGIN_PAGE;
import static by.vasiliuk.project.command.ParameterName.*;

public class RegisterUserCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String username = request.getParameter(NAME);
        String pass = request.getParameter(PASSWORD);
        String averageRating = request.getParameter(AVG_RATING);

        UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();
        try {
            userServiceImpl.registerUser(username, HashUtil.hash(pass), averageRating);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return LOGIN_PAGE;
    }
}