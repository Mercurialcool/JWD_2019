package by.webparsing.vadim.impl;

import by.webparsing.vadim.entity.Candy;
import by.webparsing.vadim.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class SaxParser implements Parser {

    private final static Logger logger = LogManager.getLogger();

    @Override
    public List<Candy> parse(InputStream inputStream) {
        logger.info("Parsing xml file with Sax parser");
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SweetHandler sweetHandler = new SweetHandler();
            saxParser.parse(inputStream, sweetHandler);
            return sweetHandler.getCandies();
        } catch (ParserConfigurationException| SAXException| IOException e){
            logger.error(e.toString());
        }
        return null;
    }
}

