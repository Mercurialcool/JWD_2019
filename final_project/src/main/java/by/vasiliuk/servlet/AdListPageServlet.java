package main.java.by.vasiliuk.servlet;

import main.java.by.vasiliuk.command.GetAdvertsBySectionIdCommand;
import main.java.by.vasiliuk.command.GetAllAdvertsCommand;
import main.java.by.vasiliuk.dto.AdvertTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdListPageServlet extends HttpServlet {


    private static final String ADLIST = "ad_list_page.jsp";
    private static final String ADVERTLIST = "advertList";
    private static final String SID = "sid";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<AdvertTo> advertList;

        if(request.getParameter(SID) == null){
            GetAllAdvertsCommand getAdvertsCommand = new GetAllAdvertsCommand();
            getAdvertsCommand.execute();
            advertList = getAdvertsCommand.getAdverts();
        }
        else {
            GetAdvertsBySectionIdCommand getAdvertsBySectionIdCommand =
                    new GetAdvertsBySectionIdCommand(Long.parseLong(request.getParameter(SID)));
            getAdvertsBySectionIdCommand.execute();
            advertList = getAdvertsBySectionIdCommand.getAdvertTos();
        }

        request.setAttribute(ADVERTLIST, advertList);
        request.getRequestDispatcher(ADLIST).forward(request, response);
    }
}
