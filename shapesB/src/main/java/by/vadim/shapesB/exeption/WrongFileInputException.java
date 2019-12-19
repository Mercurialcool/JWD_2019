package by.vadim.shapesB.exeption;

public class WrongFileInputException extends Exception {
    public WrongFileInputException() {
    }

    public WrongFileInputException(String message) {
        super(message);
    }

    public WrongFileInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFileInputException(Throwable cause) {
        super(cause);
    }
}
