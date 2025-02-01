package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;

/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a new MarkCommand with the specified task index.
     *
     * @param taskIndex the index of the task to mark
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) throws TaskException {
        if (taskIndex < 0 || taskIndex >= tasks.getTasks().size()) {
            throw new TaskException("The task index provided is out of bounds.");
        }
        Task task = tasks.getTasks().get(taskIndex);
        task.mark();
        storage.saveTodoList(tasks.getTasks());
        return "Nice! I've marked this task as done:\n\t" + task;
    }
}
