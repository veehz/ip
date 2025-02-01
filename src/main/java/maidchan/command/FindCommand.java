package maidchan.command;

import java.util.ArrayList;
import java.util.List;

import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents a command to find tasks.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Creates a new FindCommand with the given keyword.
     *
     * @param keyword The keyword to search for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> foundTasks = tasks.findTasks(keyword);
        if (foundTasks.isEmpty()) {
            ui.sendMessage("There are no matching tasks in your list.");
        } else {
            ArrayList<String> messages = new ArrayList<>();
            messages.add("Here are the matching tasks in your list:");
            for (int i = 0; i < foundTasks.size(); i++) {
                messages.add("\t" + (i + 1) + ". " + foundTasks.get(i).toString());
            }
            ui.sendMessage(messages);
        }
    }
}
