package by.webparsing.vadim.parsers;

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
