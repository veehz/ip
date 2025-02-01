package maidchan.command;

import maidchan.storage.Storage;
import maidchan.task.TaskList;

/**
 * Represents a command to list tasks.
 */
public class ListCommand extends Command {
    @Override
    public String execute(TaskList tasks, Storage storage) {
        if (tasks.getTasks().isEmpty()) {
            return "You have no tasks in the list.";
        } else {
            StringBuilder message = new StringBuilder("Here are the tasks in your list:");
            for (int i = 0; i < tasks.getTasks().size(); i++) {
                message.append("\n\t").append(i + 1).append(". ").append(tasks.getTasks().get(i).toString());
            }
            return message.toString();
        }
    }
}
