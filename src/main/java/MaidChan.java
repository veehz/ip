import exceptions.CommandNotFoundException;
import exceptions.TaskException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

/**
 * The main class of MaidChan.
 * MaidChan is a simple chatbot that helps you manage your tasks.
 */
public class MaidChan {
    /** The name of MaidChan. */
    private static String name = "MaidChan";

    /**
     * The entry point of MaidChan.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String logo = " __  __       _     _  ____ _\n"
                + "|  \\/  | __ _(_) __| |/ ___| |__   __ _ _ __\n"
                + "| |\\/| |/ _` | |/ _` | |   | '_ \\ / _` | '_ \\\n"
                + "| |  | | (_| | | (_| | |___| | | | (_| | | | |\n"
                + "|_|  |_|\\__,_|_|\\__,_|\\____|_| |_|\\__,_|_| |_|\n";
        Scanner scanner = new Scanner(System.in);
        System.out.println(logo);
        sendMessage(List.of("Hello! I'm " + MaidChan.name + ".", "What can I do for you?"));

        ArrayList<Task> tasks = new ArrayList<>();

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
                handleInput(tasks, input);
            } catch (CommandNotFoundException e) {
                sendMessage(e.getMessage());
            } catch (TaskException e) {
                sendMessage("Error: " + e.getMessage());
            }
        }

        sendMessage("Bye. Hope to see you again soon!");
        scanner.close();
    }

    private static void handleInput(ArrayList<Task> tasks, String input)
            throws CommandNotFoundException, TaskException {
        if (input.equals("list")) {
            ArrayList<String> messages = new ArrayList<>();
            messages.add("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                messages.add("\t" + (i + 1) + ". " + tasks.get(i).toString());
            }
            sendMessage(messages);
            return;
        }

        if (input.startsWith("mark")) {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new TaskException("Please specify a task number to mark.");
            }

            int taskNumber = Integer.parseInt(parts[1]);
            if (taskNumber < 1 || taskNumber > tasks.size()) {
                throw new TaskException("Task number out of range.");
            }

            tasks.get(taskNumber - 1).mark();
            sendMessage("Nice! I've marked this task as done:\n\t"
                    + tasks.get(taskNumber - 1).toString());
            return;
        }

        if (input.startsWith("unmark")) {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new TaskException("Please specify a task number to unmark.");
            }

            int taskNumber = Integer.parseInt(parts[1]);
            if (taskNumber < 1 || taskNumber > tasks.size()) {
                throw new TaskException("Task number out of range.");
            }

            tasks.get(taskNumber - 1).unmark();
            sendMessage(
                    "Nice! I've unmarked this task:\n\t" + tasks.get(taskNumber - 1).toString());
            return;
        }

        Task toAddTask = null;

        if (input.startsWith("todo")) {
            String description = input.substring("todo".length());
            toAddTask = new ToDo(description);
        }

        if (input.startsWith("deadline")) {
            String description = input.substring("deadline".length());
            toAddTask = new Deadline(description);
        }

        if (input.startsWith("event")) {
            String description = input.substring("event".length());
            toAddTask = new Event(description);
        }

        if (toAddTask != null) {
            tasks.add(toAddTask);
            sendMessage("Got it. I've added this task:\n\t" + toAddTask.toString() + "\n"
                    + "Now you have " + tasks.size() + " tasks in the list.");
            return;
        }

        // sendMessage("I don't understand you (yet).");
        throw new CommandNotFoundException("I don't understand you (yet).");
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
