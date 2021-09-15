/**
 * Thrown if password does not contain a special character.
 * @author Randall Kim
 */
public class NoSpecialCharacterException extends RuntimeException {
    /**
     * Constructs a NoSpecialCharacterException with default error message.
     */
    public NoSpecialCharacterException() {
        super("The password must contain at least one special character");
    }
}
