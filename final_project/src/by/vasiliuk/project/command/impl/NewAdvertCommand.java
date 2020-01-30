package main.java.by.vasiliuk.command.impl;

import main.java.by.vasiliuk.command.Command;
import main.java.by.vasiliuk.service.AdvertService;

import javax.servlet.http.HttpServletRequest;

public class NewAdvertCommand implements Command {

    private static final String RETURN_PAGE = "some_page.jsp";
    private static final String TITLE = "title";
    private static final String TEXT = "text";
    //private static final long USER_ID = ;



    @Override
    public String execute(HttpServletRequest request) {
        String title = request.getParameter(TITLE);
        String text = request.getParameter(TEXT);
        //long userId = request.getParameter(USER_ID);
        AdvertService advertService = AdvertService.getInstance();
        //advertService.saveAdvert(title, text, userId);
        return RETURN_PAGE;


    }
}
