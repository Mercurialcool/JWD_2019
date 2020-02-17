package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.service.impl.AdvertServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.vasiliuk.project.command.JspPath.RETURN_PAGE;
import static by.vasiliuk.project.command.ParameterName.TEXT;
import static by.vasiliuk.project.command.ParameterName.TITLE;

public class NewAdvertCommand implements Command {


    //private static final long USER_ID = ;



    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String title = request.getParameter(TITLE);
        String text = request.getParameter(TEXT);
    //   long userId =Long.valueOf( request.getParameter(USER_ID));
        AdvertServiceImpl advertServiceImpl = AdvertServiceImpl.getInstance();
        //advertService.saveAdvert(title, text, userId);
        return RETURN_PAGE;


    }
}
