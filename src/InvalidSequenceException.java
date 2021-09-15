/**
 * Thrown when a password contains more than two of the same character in a row.
 * @author Randall Kim
 */
public class InvalidSequenceException extends RuntimeException {
    /**
     * Constructs an InvalidSequenceException with default error message.
     */
    public InvalidSequenceException() {
        super("The password cannot contain more than two of the same character in sequence.");
    }
}
