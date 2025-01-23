import exceptions.CommandNotFoundException;

public enum Command {
    LIST, MARK, UNMARK, DELETE, TODO, DEADLINE, EVENT;

    public static Command fromString(String command) throws CommandNotFoundException {
        switch (command.toLowerCase()) {
            case "list":
                return LIST;
            case "mark":
                return MARK;
            case "unmark":
                return UNMARK;
            case "delete":
                return DELETE;
            case task.ToDo.COMMAND_NAME:
                return TODO;
            case task.Deadline.COMMAND_NAME:
                return DEADLINE;
            case task.Event.COMMAND_NAME:
                return EVENT;
            default:
                throw new CommandNotFoundException(command);
        }
    }
}