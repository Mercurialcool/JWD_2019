package main.java.by.vasiliuk.command.impl;


import main.java.by.vasiliuk.command.Command;
import main.java.by.vasiliuk.service.ServiceException;
import main.java.by.vasiliuk.service.UserService;
import main.java.by.vasiliuk.service.HashUtil;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    private static final String LOGIN_PAGE = "some_page.jsp";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {

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