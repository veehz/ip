package maidchan.command;

import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

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
