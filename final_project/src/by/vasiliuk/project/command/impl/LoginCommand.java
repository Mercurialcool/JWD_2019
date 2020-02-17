package by.vasiliuk.project.command.impl;


import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.service.impl.UserServiceImpl;
import by.vasiliuk.project.service.ServiceException;
import by.vasiliuk.project.util.HashUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
;
import static by.vasiliuk.project.command.JspPath.AD_LIST;
import static by.vasiliuk.project.command.JspPath.LOGIN_PAGE;
import static by.vasiliuk.project.command.ParameterName.NAME;
import static by.vasiliuk.project.command.ParameterName.PASSWORD;

public class LoginCommand implements Command {
    static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {

         String page = LOGIN_PAGE;
         String username = request.getParameter(NAME);
         String pass = request.getParameter(PASSWORD);

        UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();
        try {
            String passFromDb = userServiceImpl.logInUser(username);
            if (HashUtil.check(pass, passFromDb)){
                page =  AD_LIST;
            }
        } catch (ServiceException e) {
            logger.error("error in LoginService", e);
           page = LOGIN_PAGE; /// other page?
        }
        return page;
    }

}