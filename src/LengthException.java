/**
 * Thrown when a password is less than 6 characters long.
 * @author Randall Kim
 */
public class LengthException extends RuntimeException{
    /**
     * Constructs a LengthException with default error message.
     */
    public LengthException() {
        super("The password must be at least 6 characters long");
    }
}
