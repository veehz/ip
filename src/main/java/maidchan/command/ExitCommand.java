package maidchan.command;

import maidchan.storage.Storage;
import maidchan.task.TaskList;

/**
 * Represents a command to exit.
 */
public class ExitCommand extends Command {
    @Override
    public String execute(TaskList tasks, Storage storage) {
        return "Bye. Hope to see you again soon!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
