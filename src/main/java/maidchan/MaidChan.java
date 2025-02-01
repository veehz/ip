package maidchan;

import java.io.File;
import java.util.Scanner;

import maidchan.command.Command;
import maidchan.exceptions.CommandNotFoundException;
import maidchan.exceptions.MaidChanUnexpectedException;
import maidchan.exceptions.TaskException;
import maidchan.storage.Storage;
import maidchan.task.TaskList;
import maidchan.ui.Ui;

/**
 * Represents the MaidChan bot.
 */
public class MaidChan {
    private static TaskList taskList;
    private static Ui ui;
    private static Storage storage;
    private static Parser parser;

    /**
     * Starts the MaidChan bot.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ui = new Ui();
        ui.showWelcomeMessage();

        storage = new Storage(System.getProperty("user.dir") + File.separator + "data"
                + File.separator + "tasks.txt");
        taskList = new TaskList();
        taskList.getTasks().addAll(storage.loadTodoList());
        parser = new Parser();

        boolean isExit = false;
        while (!isExit) {
            System.out.println("[You]");
            if (!scanner.hasNextLine()) { // Break if no more input
                break;
            }
            String input = scanner.nextLine();
            if (input == null || input.isEmpty()) {
                continue;
            }

            System.out.println();
            try {
                ui.startMessage();
                Command command = parser.parseCommand(input);
                command.execute(taskList, ui, storage);
                isExit = command.isExit();
            } catch (TaskException e) {
                ui.sendMessage("Error: " + e.getMessage());
            } catch (CommandNotFoundException e) {
                // e.getMessage() is the command that was not found
                ui.sendMessage("I don't understand you (yet).");
            } catch (MaidChanUnexpectedException e) {
                ui.sendMessage("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}
