package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.note.Note;
import maidchan.note.NoteList;
import maidchan.storage.Storage;
import maidchan.task.TaskList;

/**
 * Represents a command to add a note.
 */
public class AddNoteCommand extends Command {
    private Note note;

    /**
     * Constructs a new AddNoteCommand with the specified note.
     *
     * @param note the note to add
     */
    public AddNoteCommand(Note note) {
        this.note = note;
    }

    /**
     * Executes the command to add a note.
     *
     * @param tasks   the list of tasks
     * @param storage the storage
     * @return the result message of the command execution
     * @throws TaskException if an error occurs during execution
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws TaskException {
        NoteList notes = NoteList.getInstance();
        notes.addNote(note);
        return "Added note: " + note;
    }
}
