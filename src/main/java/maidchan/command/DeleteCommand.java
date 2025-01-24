package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a new DeleteCommand with the specified task index.
     *
     * @param taskIndex the index of the task to delete
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException {
        Task task = tasks.getTasks().get(taskIndex);
        tasks.removeTask(taskIndex);
        ui.sendMessage("Noted. I've removed this task:\n\t" + task.toString()
                + "\nNow you have " + tasks.getTasks().size() + " tasks in the list.");
        storage.saveTodoList(tasks.getTasks());
    }
}
