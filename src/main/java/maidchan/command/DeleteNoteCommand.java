package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.note.Note;
import maidchan.note.NoteList;
import maidchan.storage.Storage;
import maidchan.task.TaskList;

/**
 * Represents a command to delete a note.
 */
public class DeleteNoteCommand extends Command {
    private int index;

    /**
     * Constructs a new DeleteNoteCommand with the specified index.
     *
     * @param index the index of the note to delete
     */
    public DeleteNoteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command to delete a note.
     *
     * @param tasks   the list of tasks
     * @param storage the storage
     * @return the result message of the command execution
     * @throws TaskException if an error occurs during execution
     */
    @Override
    public String execute(TaskList tasks, Storage storage) throws TaskException {
        NoteList notes = NoteList.getInstance();
        try {
            Note note = notes.getNotes().get(index);
            notes.removeNote(index);
            return "Deleted note: " + note;
        } catch (IndexOutOfBoundsException e) {
            throw new TaskException("Invalid note index.");
        }
    }
}
