package by.vadim.shapesB.exeption;

public class LessThanZeroException extends Exception {
    public LessThanZeroException() {
    }

    public LessThanZeroException(String message) {
        super(message);
    }

    public LessThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public LessThanZeroException(Throwable cause) {
        super(cause);
    }
}
