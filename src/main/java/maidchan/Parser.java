package maidchan;

import maidchan.command.AddCommand;
import maidchan.command.Command;
import maidchan.command.DeleteCommand;
import maidchan.command.ExitCommand;
import maidchan.command.ListCommand;
import maidchan.command.MarkCommand;
import maidchan.command.UnmarkCommand;
import maidchan.exceptions.CommandNotFoundException;
import maidchan.exceptions.TaskException;
import maidchan.task.Deadline;
import maidchan.task.Event;
import maidchan.task.ToDo;

/**
 * Parses user input into commands.
 */
public class Parser {
    /**
     * Parses the given command string and returns the corresponding Command object.
     *
     * @param command The command string to parse.
     * @return The Command object corresponding to the parsed command.
     * @throws CommandNotFoundException If the command is not recognized.
     * @throws TaskException If there is an error related to task operations.
     */
    public Command parseCommand(String command) throws CommandNotFoundException, TaskException {
        String[] parts = command.split(" ", 2);
        String commandType = parts[0];
        String description = parts.length > 1 ? parts[1] : "";

        try {
            switch (commandType) {
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(Integer.parseInt(description) - 1);
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(description) - 1);
            case "delete":
                return new DeleteCommand(Integer.parseInt(description) - 1);
            case ToDo.COMMAND_NAME:
                return new AddCommand(new ToDo(description));
            case Deadline.COMMAND_NAME:
                return new AddCommand(new Deadline(description));
            case Event.COMMAND_NAME:
                return new AddCommand(new Event(description));
            case "bye":
                return new ExitCommand();
            default:
                throw new CommandNotFoundException(commandType);
            }
        } catch (NumberFormatException e) {
            switch (commandType) {
            case "mark":
                throw new TaskException("Please specify a valid task number to mark.");
            case "unmark":
                throw new TaskException("Please specify a valid task number to unmark.");
            case "delete":
                throw new TaskException("Please specify a valid task number to delete.");
            default:
                throw new TaskException("Please specify a valid task number.");
            }
        }
    }
}
