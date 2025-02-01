package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;

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
    public String execute(TaskList tasks, Storage storage) throws TaskException {
        if (taskIndex < 0 || taskIndex >= tasks.getTasks().size()) {
            throw new TaskException("The task index provided is out of bounds.");
        }
        Task task = tasks.getTasks().get(taskIndex);
        tasks.removeTask(taskIndex);
        storage.saveTodoList(tasks.getTasks());
        return "Noted. I've removed this task:\n\t" + task.toString()
                + "\nNow you have " + tasks.getTasks().size() + " tasks in the list.";
    }
}
