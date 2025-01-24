package maidchan.command;

import maidchan.storage.Storage;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents a command to exit.
 */
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.sendMessage("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
