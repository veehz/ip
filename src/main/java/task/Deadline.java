package task;

import exceptions.TaskException;

public class Deadline extends Task {
    private String by;

    public Deadline(String description) throws TaskException {
        super(description);

        // Split into [description] /by [by]

        String[] parts = description.split("/by");

        setDescription(parts[0].trim());

        if (parts.length != 2) {
            throw new TaskException("Deadline description must contain exactly one /by");
        }

        this.by = parts[1].trim();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
