package task;

import exceptions.TaskException;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) throws TaskException {
        this.description = description.trim();
        if (this.description.isEmpty()) {
            throw new TaskException("The description of a task cannot be empty.");
        }
        this.isDone = false;
    }

    protected void setDescription(String description) throws TaskException{
        if (description.trim().isEmpty()) {
            throw new TaskException("The description of a task cannot be empty.");
        }
        this.description = description.trim();
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (this.isDone ? "X" : " ") + "] " + this.description;
    }
}
