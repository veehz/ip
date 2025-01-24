package maidchan.exceptions;

/**
 * Exception thrown when a command is not found.
 */
public class CommandNotFoundException extends Exception {

    /**
     * Constructs a new CommandNotFoundException with the message to be shown to user.
     *
     * @param message the message to be shown to user
     */
    public CommandNotFoundException(String message) {
        super(message);
    }
}