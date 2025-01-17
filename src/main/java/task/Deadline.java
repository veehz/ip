package task;

public class Deadline extends Task {
    private String by;

    public Deadline(String description) {
        super(description);

        // Split into [description] /by [by]

        String[] parts = description.split("/by");
        this.description = parts[0].trim();

        // Need to handle case where /by is not present, or when multiple /by

        this.by = parts[1].trim();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
