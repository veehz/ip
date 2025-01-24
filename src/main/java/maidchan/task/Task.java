package maidchan.task;

import maidchan.exceptions.MaidChanUnexpectedException;
import maidchan.exceptions.TaskException;

/**
 * Represents a task that can be done. This is the superclass of all tasks.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    public static final String COMMAND_NAME = "task";

    /**
     * Constructs a new Task with the description.
     *
     * @param description the description of the task
     * @throws TaskException if the description is empty
     */
    public Task(String description) throws TaskException {
        setDescription(description);
        this.isDone = false;
    }

    private String getCommandName() throws NoSuchFieldException, IllegalAccessException {
        return this.getClass().getDeclaredField("COMMAND_NAME").get(null).toString();
    }

    /**
     * Sets the description of the task.
     *
     * @param description the new description of the task
     * @throws TaskException if the description is empty
     */
    protected void setDescription(String description) throws TaskException {
        this.description = description.trim();
        if (this.description.isEmpty()) {
            try {
                throw new TaskException(
                        "The description of a " + getCommandName() + " cannot be empty.");
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new MaidChanUnexpectedException(
                        "Failed to get COMMAND_NAME: " + e.getMessage());
            }
        }
    }

    /**
     * Mark this task as done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmark this task as done.
     */
    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (this.isDone ? "X" : " ") + "] " + this.description;
    }

    /**
     * Returns the string representation of the task for storage.
     *
     * @return the string representation of the task for storage
     */
    public String toRepr() {
        try {
            return (this.isDone ? "1 " : "0 ") + getCommandName() + " " + this.description;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new MaidChanUnexpectedException("Failed to get COMMAND_NAME: " + e.getMessage());
        }
    }
}
