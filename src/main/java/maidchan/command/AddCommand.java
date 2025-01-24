package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents a command to add a task.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs a new AddCommand with the specified task.
     *
     * @param task the task to add
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException {
        tasks.addTask(task);
        ui.sendMessage("Got it. I've added this task:\n\t" + task.toString() + "\n"
                + "Now you have " + tasks.getTasks().size() + " tasks in the list.");
        storage.saveTodoList(tasks.getTasks());
    }
}
