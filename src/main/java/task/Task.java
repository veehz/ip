package task;

import exceptions.TaskException;

/**
 * Represents a task that can be done.
 * This is the superclass of all tasks.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the description.
     *
     * @param description the description of the task
     * @throws TaskException if the description is empty
     */
    public Task(String description) throws TaskException {
        this.description = description.trim();
        if (this.description.isEmpty()) {
            throw new TaskException("The description of a task cannot be empty.");
        }
        this.isDone = false;
    }

    /**
     * Sets the description of the task.
     *
     * @param description the new description of the task
     * @throws TaskException if the description is empty
     */
    protected void setDescription(String description) throws TaskException {
        if (description.trim().isEmpty()) {
            throw new TaskException("The description of a task cannot be empty.");
        }
        this.description = description.trim();
    }

    /** Mark this task as done. */
    public void mark() {
        this.isDone = true;
    }

    /** Unmark this task as done. */
    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (this.isDone ? "X" : " ") + "] " + this.description;
    }
}
