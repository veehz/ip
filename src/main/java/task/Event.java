package task;

public class Event extends Task {
    private String from;
    private String to;

    public Event(String description) {
        super(description);

        // Split into [description] /from [from] /to [to]

        String[] parts = description.split("/from");
        this.description = parts[0].trim();

        // Need to handle case where /from is not present, or when multiple /from

        parts = parts[1].split("/to");

        // Need to handle case where /to is not present, or when multiple /to

        this.from = parts[0].trim();
        this.to = parts[1].trim();
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + ", to: " + this.to + ")";
    }
}
