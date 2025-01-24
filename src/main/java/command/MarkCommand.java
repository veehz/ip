package command;

import exceptions.TaskException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException {
        Task task = tasks.getTasks().get(taskIndex);
        task.mark();
        ui.sendMessage("Nice! I've marked this task as done:\n\t" + task.toString());
        storage.saveTodoList(tasks.getTasks());
    }
}
