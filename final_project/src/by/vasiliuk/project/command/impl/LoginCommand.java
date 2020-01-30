package by.vasiliuk.project.command.impl;


import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.service.impl.UserService;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.util.HashUtil;

import javax.servlet.http.HttpServletRequest;
;
import static by.vasiliuk.project.command.JspProvider.LOGIN_PAGE;
import static by.vasiliuk.project.command.TitleProvider.NAME;
import static by.vasiliuk.project.command.TitleProvider.PASSWORD;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request)throws CommandException {

         String page = LOGIN_PAGE;
         String username = request.getParameter(NAME);
         String pass = request.getParameter(PASSWORD);

        UserService userService = UserService.getInstance();
        try {
            if (HashUtil.check(pass, userService.logInUser(username))){
                return page;
            }
        } catch (ServiceException e) {
           page = LOGIN_PAGE;
        }
        return page;
    }

}