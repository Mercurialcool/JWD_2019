package by.webparsing.vadim.exception;

import javax.servlet.ServletException;

public class ParserNotFoundException extends ServletException {
    public ParserNotFoundException() {
        super();
    }

    public ParserNotFoundException(String message) {
        super(message);
    }

    public ParserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserNotFoundException(Throwable cause) {
        super(cause);
    }
}
