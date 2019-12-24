package by.webparsing.vadim.servlet;

import by.webparsing.vadim.parsers.Parsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","xml");
        request.setAttribute("parsers", Parsers.values());
        request.getRequestDispatcher("upload-page.jsp").forward(request,response);
    }
}
