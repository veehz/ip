package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.note.Note;
import maidchan.note.NoteList;
import maidchan.storage.Storage;
import maidchan.task.TaskList;

import java.util.ArrayList;

/**
 * Represents a command to list all notes.
 */
public class ListNoteCommand extends Command {

    /**
     * Constructs a new ListNoteCommand.
     */
    public ListNoteCommand() {
    }

    /**
     * Executes the command to list all notes.
     *
     * @param tasks   the list of tasks
     * @param storage the storage
     * @return the result message of the command execution
     * @throws TaskException if an error occurs during execution
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws TaskException {
        NoteList notes = NoteList.getInstance();
        ArrayList<Note> noteList = notes.getNotes();
        if (noteList.isEmpty()) {
            return "No notes available.";
        } else {
            StringBuilder sb = new StringBuilder("Notes:\n");
            for (int i = 0; i < noteList.size(); i++) {
                sb.append((i + 1)).append(". ").append(noteList.get(i)).append("\n");
            }
            return sb.toString().trim();
        }
    }
}
