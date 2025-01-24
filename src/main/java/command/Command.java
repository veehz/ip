package command;

import exceptions.TaskException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException;

    public boolean isExit() {
        return false;
    }
}
