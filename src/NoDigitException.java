/**
 * Thrown when a password does not have a numeric digit.
 * @author Randall Kim
 */
public class NoDigitException extends RuntimeException {
    /**
     * Constructs a NoDigitException with default error message.
     */
    public NoDigitException() {
        super("The password must contain at least one digit");
    }
}