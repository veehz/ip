package maidchan.task;

import maidchan.exceptions.TaskException;

/**
 * Represents a task that can be done. This is the most basic task.
 */
public class ToDo extends Task {
    public static final String COMMAND_NAME = "todo";

    /**
     * Constructs a new ToDo with the description.
     *
     * @param description the description of the task
     * @throws TaskException if the description is empty
     */
    public ToDo(String description) throws TaskException {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toRepr() {
        return super.toRepr();
    }
}
