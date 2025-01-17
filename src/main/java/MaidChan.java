import java.util.ArrayList;
import java.util.List;

public class MaidChan {
    private static String name = "MaidChan";
    public static void main(String[] args) {
        String logo = " __  __       _     _  ____ _\n"
                    + "|  \\/  | __ _(_) __| |/ ___| |__   __ _ _ __\n"
                    + "| |\\/| |/ _` | |/ _` | |   | '_ \\ / _` | '_ \\\n"
                    + "| |  | | (_| | | (_| | |___| | | | (_| | | | |\n"
                    + "|_|  |_|\\__,_|_|\\__,_|\\____|_| |_|\\__,_|_| |_|\n";
        System.out.println(logo);
        sendMessage(List.of(
            "Hello! I'm " + MaidChan.name + ".",
            "What can I do for you?"
        ));

        ArrayList<Task> tasks = new ArrayList<>();

        while(true) {
            System.out.println("[You]");
            String input = System.console().readLine();
            if(input == null || input.isEmpty()) {
                continue;
            }

            System.out.println();
            if(input.equals("bye")) {
                break;
            }

            if(input.equals("list")) {
                ArrayList<String> messages = new ArrayList<>();
                messages.add("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    messages.add((i + 1) + ". " + tasks.get(i).toString());
                }
                sendMessage(messages);
                continue;
            }

            tasks.add(new Task(input));

            sendMessage("Added a task: " + input);
        }

        sendMessage("Bye. Hope to see you again soon!");
    }

    private static void sendMessage(String message) {
        System.out.println("[" + MaidChan.name + "]");
        System.out.println(message);
        if(!message.endsWith("\n")) {
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
