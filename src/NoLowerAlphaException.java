/**
 * Thrown when a password does not contain a lowercase letter.
 * @author Randall Kim
 */
public class NoLowerAlphaException extends RuntimeException {
    /**
     * Constructs a NoLowerAlphaException with default error message.
     */
    public NoLowerAlphaException() {
        super("The password must contain at least one lowercase alphabetic character");
    }
}
