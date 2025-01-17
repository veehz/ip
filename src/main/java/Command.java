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
            case "todo":
                return TODO;
            case "deadline":
                return DEADLINE;
            case "event":
                return EVENT;
            default:
                throw new CommandNotFoundException(command);
        }
    }
}