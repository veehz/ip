package task;

import exceptions.TaskException;

public class Event extends Task {
    private String from;
    private String to;

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
}
