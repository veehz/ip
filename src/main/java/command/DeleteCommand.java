package command;

import exceptions.TaskException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {
    private int taskIndex;

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
