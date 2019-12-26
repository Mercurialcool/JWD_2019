package by.webparsing.vadim.parser;

import by.webparsing.vadim.entity.Candy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface Parser {
    List<Candy> parse(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException;
}
