package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a new UnmarkCommand with the specified task index.
     *
     * @param taskIndex the index of the task to unmark
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException {
        Task task = tasks.getTasks().get(taskIndex);
        task.unmark();
        ui.sendMessage("Nice! I've unmarked this task:\n\t" + task);
        storage.saveTodoList(tasks.getTasks());
    }
}
