package task;

import exceptions.TaskException;

public class ToDo extends Task {
    public ToDo(String description) throws TaskException {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
