package by.webparsing.vadim.parsers;

public enum Parsers {
    DOM("DOM"),
    SAX("SAX"),
    STAX("StAX"),
    XPATH("Xpath");

    private String parser;

    private Parsers(String s){
        parser = s;
    }

    public String getParser(){
        return parser;
    }

    public void setParser(String parserName){
        parser = parserName;
    }
}
