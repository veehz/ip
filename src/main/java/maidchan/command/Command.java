package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents a command that can be executed.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks   the list of tasks
     * @param ui      the user interface
     * @param storage the storage
     * @throws TaskException if an error occurs during execution
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException;

    /**
     * Returns whether the command is an exit command.
     *
     * @return true if the command is an exit command, false otherwise
     */
    public boolean isExit() {
        return false;
    }
}
