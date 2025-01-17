import exceptions.CommandNotFoundException;
import exceptions.MaidChanUnexpectedException;
import exceptions.TaskException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

public class MaidChan {
    private static String name = "MaidChan";
    private static ArrayList<Task> tasks;

    public static void main(String[] args) {
        String logo = " __  __       _     _  ____ _\n"
                + "|  \\/  | __ _(_) __| |/ ___| |__   __ _ _ __\n"
                + "| |\\/| |/ _` | |/ _` | |   | '_ \\ / _` | '_ \\\n"
                + "| |  | | (_| | | (_| | |___| | | | (_| | | | |\n"
                + "|_|  |_|\\__,_|_|\\__,_|\\____|_| |_|\\__,_|_| |_|\n";
        Scanner scanner = new Scanner(System.in);
        System.out.println(logo);
        sendMessage(List.of("Hello! I'm " + MaidChan.name + ".", "What can I do for you?"));

        tasks = new ArrayList<>();

        while (true) {
            System.out.println("[You]");
            if (!scanner.hasNextLine()) { // Break if no more input
                break;
            }
            String input = scanner.nextLine();
            if (input == null || input.isEmpty()) {
                continue;
            }

            System.out.println();
            if (input.equals("bye")) {
                break;
            }

            try {
                handleInput(input);
            } catch (TaskException e) {
                sendMessage("Error: " + e.getMessage());
            } catch (CommandNotFoundException e) {
                // e.getMessage() is the command that was not found
                sendMessage("I don't understand you (yet).");
            } catch (MaidChanUnexpectedException e) {
                sendMessage("An unexpected error occurred: " + e.getMessage());
            }
        }

        sendMessage("Bye. Hope to see you again soon!");
        scanner.close();
    }

    private static void handleInput(String input) throws CommandNotFoundException, TaskException {
        String[] parts = input.split(" ", 2);
        Command command = Command.fromString(parts[0]);


        switch (command) {
            case LIST:
                if (tasks.isEmpty()) {
                    sendMessage("You have no tasks in the list.");
                } else {
                    ArrayList<String> messages = new ArrayList<>();
                    messages.add("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        messages.add("\t" + (i + 1) + ". " + tasks.get(i).toString());
                    }
                    sendMessage(messages);
                }
                break;
            case MARK:
            case UNMARK:
            case DELETE:
                handleTaskModification(command, parts);
                break;
            case TODO:
            case DEADLINE:
            case EVENT:
                handleTaskCreation(command, parts);
                break;
            default:
                // All commands should have been handled; invalid commands are caught in
                // Command.fromString()
                throw new MaidChanUnexpectedException("Command not handled: " + command);
        }
    }

    private static void handleTaskModification(Command command, String[] parts)
            throws TaskException {
        if (parts.length != 2) {
            throw new TaskException(
                    "Please specify a task number to " + command.toString().toLowerCase() + ".");
        }

        int taskNumber;
        try {
            taskNumber = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new TaskException("Please specify a valid task number to "
                    + command.toString().toLowerCase() + ".");
        }
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            throw new TaskException("Task number out of range.");
        }

        Task task = tasks.get(taskNumber - 1);
        switch (command) {
            case MARK:
                task.mark();
                sendMessage("Nice! I've marked this task as done:\n\t" + task.toString());
                break;
            case UNMARK:
                task.unmark();
                sendMessage("Nice! I've unmarked this task:\n\t" + task.toString());
                break;
            case DELETE:
                tasks.remove(taskNumber - 1);
                sendMessage("Noted. I've removed this task:\n\t" + task.toString()
                        + "\nNow you have " + tasks.size() + " tasks in the list.");
                break;
            default:
                throw new MaidChanUnexpectedException(
                        "Command (task modification) not handled: " + command);
        }
    }

    private static void handleTaskCreation(Command command, String[] parts) throws TaskException {
        if (parts.length != 2) {
            throw new TaskException("The description of a " + command.toString().toLowerCase()
                    + " cannot be empty.");
        }

        Task toAddTask;
        String description = parts[1];

        switch (command) {
            case TODO:
                toAddTask = new ToDo(description);
                break;
            case DEADLINE:
                toAddTask = new Deadline(description);
                break;
            case EVENT:
                toAddTask = new Event(description);
                break;
            default:
                throw new MaidChanUnexpectedException(
                        "Command (task creation) not handled: " + command);
        }

        tasks.add(toAddTask);
        sendMessage("Got it. I've added this task:\n\t" + toAddTask.toString() + "\n"
                + "Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void sendMessage(String message) {
        System.out.println("[" + MaidChan.name + "]");
        System.out.println(message);
        if (!message.endsWith("\n")) {
            System.out.println();
        }
    }

    private static <T extends Iterable<String>> void sendMessage(T messages) {
        String allMessages = "";
        for (String message : messages) {
            allMessages += message + "\n";
        }
        sendMessage(allMessages);
    }
}
