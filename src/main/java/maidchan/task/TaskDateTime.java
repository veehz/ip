package maidchan.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Parses a string into a LocalDateTime object.
 */
public class TaskDateTime {
    public static final String ACCEPTED_FORMATS = "yyyy-MM-dd HH:mm or yyyy-MM-dd";
    private boolean hasTime;
    private LocalDateTime dateTime;

    /**
     * Parses a string into a LocalDateTime object.
     *
     * @param input The string to parse.
     * @throws DateTimeParseException If the string is not in a valid date/time format.
     */
    public TaskDateTime(String input) throws DateTimeParseException {
        try {
            dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            hasTime = true;
            return;
        } catch (DateTimeParseException e) {
            // Try next formatter
        }

        try {
            dateTime = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    .atStartOfDay();
            hasTime = false;
            return;
        } catch (DateTimeParseException e) {
            // Try next formatter
        }

        throw new DateTimeParseException("Invalid date/time format", input, 0);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter;
        if (hasTime) {
            formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        } else {
            formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        }
        return dateTime.format(formatter);
    }

    /**
     * Returns a string representation that can be accepted by the constructor.
     *
     * @return The string representation.
     */
    public String toRepr() {
        DateTimeFormatter formatter;
        if (hasTime) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }
        return dateTime.format(formatter);
    }
}
