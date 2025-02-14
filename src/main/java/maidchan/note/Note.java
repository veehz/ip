package maidchan.note;

/**
 * Represents a note with a simple string content.
 */
public class Note {
    private String content;

    /**
     * Constructs a new Note with the specified content.
     *
     * @param content the content of the note
     */
    public Note(String content) {
        this.content = content;
    }

    /**
     * Returns the content of the note.
     *
     * @return the content of the note
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
