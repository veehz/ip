package exceptions;

/**
 * Exception thrown when there is an error when handling a task operation.
 */
public class TaskException extends Exception {
    /**
     * Constructs a new TaskException with the message to be shown to user.
     *
     * @param message the message to be shown to user
     */
    public TaskException(String message) {
        super(message);
    }
}
