package maidchan.task;

import maidchan.exceptions.TaskException;

/**
 * Represents a task that starts and ends at specific times.
 */
public class Event extends Task {
    private TaskDateTime from;
    private TaskDateTime to;
    public static final String COMMAND_NAME = "event";

    /**
     * Constructs a new Event with the description.
     *
     * @param description the description of the event
     * @throws TaskException if the description is empty or invalid (does not contain exactly one
     *         /from or /to)
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

        try {
            this.from = new TaskDateTime(parts[0].trim());
            this.to = new TaskDateTime(parts[1].trim());
        } catch (Exception e) {
            throw new TaskException("Invalid date/time format for event. Accepts: "
                    + TaskDateTime.ACCEPTED_FORMATS);
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from.toString() + ", to: "
                + this.to.toString() + ")";
    }

    @Override
    public String toRepr() {
        return super.toRepr() + " /from " + this.from.toRepr() + " /to " + this.to.toRepr();
    }
}
