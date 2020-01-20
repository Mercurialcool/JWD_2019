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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<AdvertTo> advertList;

        if(request.getParameter("sid") == null){
            GetAllAdvertsCommand getAdvertsCommand = new GetAllAdvertsCommand();
            getAdvertsCommand.execute();
            advertList = getAdvertsCommand.getAdverts();
        }
        else {
            GetAdvertsBySectionIdCommand getAdvertsBySectionIdCommand =
                    new GetAdvertsBySectionIdCommand(Long.parseLong(request.getParameter("sid")));
            getAdvertsBySectionIdCommand.execute();
            advertList = getAdvertsBySectionIdCommand.getAdvertTos();
        }

        request.setAttribute("advertList", advertList);
        request.getRequestDispatcher("ad_list_page.jsp").forward(request, response);
    }
}
