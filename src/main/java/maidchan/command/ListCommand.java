package maidchan.command;

import java.util.ArrayList;
import maidchan.storage.Storage;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.getTasks().isEmpty()) {
            ui.sendMessage("You have no tasks in the list.");
        } else {
            ArrayList<String> messages = new ArrayList<>();
            messages.add("Here are the tasks in your list:");
            for (int i = 0; i < tasks.getTasks().size(); i++) {
                messages.add("\t" + (i + 1) + ". " + tasks.getTasks().get(i).toString());
            }
            ui.sendMessage(messages);
        }
    }
}
