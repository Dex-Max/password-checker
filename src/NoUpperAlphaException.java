/**
 * Thrown if password does not contain an uppercase letter.
 * @author Randall Kim
 */
public class NoUpperAlphaException extends RuntimeException {
    /**
     * Constructs a NoUpperAlphaException with default error message.
     */
    public NoUpperAlphaException() {
        super("The password must contain at least one uppercase alphabetic character");
    }
}
