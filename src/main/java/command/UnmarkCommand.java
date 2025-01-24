package command;

import exceptions.TaskException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class UnmarkCommand extends Command {
    private int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TaskException {
        Task task = tasks.getTasks().get(taskIndex);
        task.unmark();
        ui.sendMessage("Nice! I've unmarked this task:\n\t" + task.toString());
        storage.saveTodoList(tasks.getTasks());
    }
}
