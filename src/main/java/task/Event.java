package task;

import exceptions.TaskException;

/**
 * Represents a task that starts and ends at specific times.
 */
public class Event extends Task {
    private String from;
    private String to;
    public static final String COMMAND_NAME = "event";

    /**
     * Constructs a new Event with the description.
     *
     * @param description the description of the event
     * @throws TaskException if the description is empty or invalid
     *     (does not contain exactly one /from or /to)
     */
    public Event(String description) throws TaskException {
        super(description);

        // Split into [description] /from [from] /to [to]

        String[] parts = description.split("/from");

        if (parts.length != 2) {
            throw new TaskException("Event description must contain exactly one /from");
        }

        setDescription(parts[0]);

        parts = parts[1].split("/to");

        if (parts.length != 2) {
            throw new TaskException("Event description must contain exactly one /to after /from");
        }

        this.from = parts[0].trim();
        this.to = parts[1].trim();
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + ", to: " + this.to + ")";
    }

    @Override
    public String toRepr() {
        return super.toRepr() + " /from " + this.from + " /to " + this.to;
    }
}
