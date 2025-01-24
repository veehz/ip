package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException;

    public boolean isExit() {
        return false;
    }
}
