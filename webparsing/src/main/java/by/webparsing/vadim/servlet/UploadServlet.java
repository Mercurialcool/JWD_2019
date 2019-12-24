package by.webparsing.vadim.servlet;


import by.webparsing.vadim.exception.ParserNotFoundException;
import by.webparsing.vadim.parsers.Parser;
import by.webparsing.vadim.parsers.ParserFactory;
import by.webparsing.vadim.validator.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;


@WebServlet("/upload-info")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Trying to get file, validate and parse it");
        String parserName = request.getParameter("parser");
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        InputStream validationContent = filePart.getInputStream();

        HttpSession session = request.getSession();
        XmlValidator xmlValidator = new XmlValidator();

        if(xmlValidator.validate(validationContent)){
            session.setAttribute("valid", "Your xml file is valid");
        }

        ParserFactory parserFactory = new ParserFactory();
        Parser parser = null;

        try {
        switch (parserName){
            case "DOM":
                parser = parserFactory.getDomParser();
                break;
            case "SAX":
                parser = parserFactory.getSaxParser();
                break;
            case "STAX":
                parser = parserFactory.getStaxParser();
                break;
            default:
                throw new ParserNotFoundException();
        }
            session.setAttribute("sweets", parser.parse(fileContent));
        } catch (ParserConfigurationException | SAXException e) {
            logger.error(e.toString());
        }


        response.sendRedirect("upload-results-page.jsp");
    }
}
