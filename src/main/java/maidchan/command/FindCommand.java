package maidchan.command;

import java.util.List;

import maidchan.storage.Storage;
import maidchan.task.Task;
import maidchan.task.TaskList;

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
    public String execute(TaskList tasks, Storage storage) {
        List<Task> foundTasks = tasks.findTasks(keyword);
        if (foundTasks.isEmpty()) {
            return "There are no matching tasks in your list.";
        } else {
            StringBuilder message = new StringBuilder("Here are the matching tasks in your list:");
            for (int i = 0; i < foundTasks.size(); i++) {
                message.append("\n\t").append(i + 1).append(". ").append(foundTasks.get(i).toString());
            }
            return message.toString();
        }
    }
}
