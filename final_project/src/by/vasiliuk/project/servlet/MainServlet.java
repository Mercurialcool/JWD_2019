package main.java.by.vasiliuk.servlet;

import main.java.by.vasiliuk.command.Command;
import main.java.by.vasiliuk.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
     String page = null;
String commandStr = request.getParameter("command");
        Command command = CommandProvider.getCommand(commandStr);
        page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
