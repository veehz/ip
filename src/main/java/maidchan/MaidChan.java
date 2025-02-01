package maidchan;

import java.io.File;

import maidchan.command.Command;
import maidchan.exceptions.CommandNotFoundException;
import maidchan.exceptions.MaidChanUnexpectedException;
import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.TaskList;

/**
 * Represents the MaidChan bot.
 */
public class MaidChan {
    private final TaskList taskList;
    private final Storage storage;
    private final Parser parser;

    /**
     * Constructs a new MaidChan bot.
     */
    public MaidChan() {
        storage = new Storage(System.getProperty("user.dir") + File.separator + "data"
                + File.separator + "tasks.txt");
        taskList = new TaskList();
        taskList.getTasks().addAll(storage.loadTodoList());
        parser = new Parser();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Command command = parser.parseCommand(input);
            return command.execute(taskList, storage);
        } catch (TaskException e) {
            return "Error: " + e.getMessage();
        } catch (CommandNotFoundException e) {
            return "I don't understand you (yet).";
        } catch (MaidChanUnexpectedException e) {
            return "An unexpected error occurred: " + e.getMessage();
        }
    }
}
