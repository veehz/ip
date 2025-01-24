package task;

import exceptions.TaskException;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {
    private TaskDateTime by;
    public static final String COMMAND_NAME = "deadline";

    /**
     * Constructs a new Deadline with the description.
     *
     * @param description the description of the deadline
     * @throws TaskException if the description is empty or invalid (does not contain exactly one
     *         /by)
     */
    public Deadline(String description) throws TaskException {
        super(description);

        // Split into [description] /by [by]

        String[] parts = description.split("/by");

        setDescription(parts[0].trim());

        if (parts.length != 2) {
            throw new TaskException("Deadline description must contain exactly one /by");
        }

        try {
            this.by = new TaskDateTime(parts[1].trim());
        } catch (Exception e) {
            throw new TaskException("Invalid date/time format for deadline. Accepts: "
                    + TaskDateTime.ACCEPTED_FORMATS);
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.toString() + ")";
    }

    @Override
    public String toRepr() {
        return super.toRepr() + " /by " + this.by.toRepr();
    }
}
