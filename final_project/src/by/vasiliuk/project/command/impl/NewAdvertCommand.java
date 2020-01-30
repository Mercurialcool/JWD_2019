package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.service.impl.AdvertService;

import javax.servlet.http.HttpServletRequest;

import static by.vasiliuk.project.command.JspProvider.RETURN_PAGE;
import static by.vasiliuk.project.command.TitleProvider.TEXT;
import static by.vasiliuk.project.command.TitleProvider.TITLE;

public class NewAdvertCommand implements Command {

    //private static final long USER_ID = ;



    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String title = request.getParameter(TITLE);
        String text = request.getParameter(TEXT);
        //long userId = request.getParameter(USER_ID);
        AdvertService advertService = AdvertService.getInstance();
        //advertService.saveAdvert(title, text, userId);
        return RETURN_PAGE;


    }
}
