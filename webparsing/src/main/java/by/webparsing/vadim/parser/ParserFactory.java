package by.webparsing.vadim.parser;

import by.webparsing.vadim.impl.DomParser;
import by.webparsing.vadim.impl.SaxParser;
import by.webparsing.vadim.impl.StaxParser;

public class ParserFactory {

    public Parser getSaxParser(){
        return new SaxParser();
    }

    public Parser getDomParser(){
        return new DomParser();
    }

    public Parser getStaxParser(){
        return new StaxParser();
    }
}
