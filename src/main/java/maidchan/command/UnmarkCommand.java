package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;

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
    public String execute(TaskList tasks, Storage storage) throws TaskException {
        Task task = tasks.getTasks().get(taskIndex);
        task.unmark();
        storage.saveTodoList(tasks.getTasks());
        return "Nice! I've unmarked this task:\n\t" + task;
    }
}
