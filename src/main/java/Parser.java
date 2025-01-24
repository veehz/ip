import command.AddCommand;
import command.Command;
import command.DeleteCommand;
import command.ExitCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import exceptions.CommandNotFoundException;
import exceptions.TaskException;
import task.Deadline;
import task.Event;
import task.ToDo;

public class Parser {
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
