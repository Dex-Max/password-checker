/**
 * Thrown if the two entries for a new password are not equal.
 * @author Randall Kim
 */
public class UnmatchedException extends RuntimeException {
    /**
     * Constructs an UnmatchedException with default error message.
     */
    public UnmatchedException() {
        super("The passwords do not match");
    }
}
