package wix1002_2024_1.Q2.Q2b;

public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super();
    }

    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException(Throwable cause) {
        super(cause);
    }
}
