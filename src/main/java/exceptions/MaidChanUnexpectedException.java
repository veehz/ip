package exceptions;

/**
 * Exception thrown when an unexpected error occurs.
 */
public class MaidChanUnexpectedException extends RuntimeException {
    /**
     * Constructs a new UnexpectedException with details of the error.
     *
     * @param message the message with details of the error
     */
    public MaidChanUnexpectedException(String message) {
        super(message);
    }
}
