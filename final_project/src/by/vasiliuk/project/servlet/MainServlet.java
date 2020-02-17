package by.vasiliuk.project.servlet;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    public static final String COMMAND = "command";

    public MainServlet() {
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String page = null;
        String commandStr = request.getParameter(COMMAND);
        Command command = CommandProvider.getCommand(commandStr);
        try {
            page = command.execute(request);
        } catch (CommandException e) {
            response.sendError(500, "error message: bad command " + e.getMessage());
        }
        request.getRequestDispatcher(page).forward(request, response);
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
