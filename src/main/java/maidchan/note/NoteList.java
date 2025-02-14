package maidchan.note;

import java.util.ArrayList;

/**
 * Represents a singleton list of notes.
 */
public class NoteList {
    private static NoteList instance;
    private final ArrayList<Note> notes;

    /**
     * Private constructor to prevent instantiation.
     */
    private NoteList() {
        this.notes = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of NoteList.
     *
     * @return the singleton instance of NoteList
     */
    public static NoteList getInstance() {
        if (instance == null) {
            instance = new NoteList();
        }
        return instance;
    }

    /**
     * Adds a note to the list.
     *
     * @param note the note to add
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Deletes a note from the list by index.
     *
     * @param index the index of the note to delete
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void removeNote(int index) {
        if (index < 0 || index >= notes.size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        notes.remove(index);
    }

    /**
     * Returns the list of notes.
     *
     * @return the list of notes
     */
    public ArrayList<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    /**
     * Returns the string representation of the list of notes.
     *
     * @return the string representation of the list of notes
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            sb.append((i + 1)).append(". ").append(notes.get(i)).append("\n");
        }
        return sb.toString().trim();
    }
}
