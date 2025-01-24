package command;

import exceptions.TaskException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class AddCommand extends Command {
    private Task task;

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
