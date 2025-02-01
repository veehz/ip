package maidchan.ui;

import java.util.List;

/**
 * Represents the user interface of the application.
 */
public class Ui {
    private static final String logo = " __  __       _     _  ____ _\n"
            + "|  \\/  | __ _(_) __| |/ ___| |__   __ _ _ __\n"
            + "| |\\/| |/ _` | |/ _` | |   | '_ \\ / _` | '_ \\\n"
            + "| |  | | (_| | | (_| | |___| | | | (_| | | | |\n"
            + "|_|  |_|\\__,_|_|\\__,_|\\____|_| |_|\\__,_|_| |_|\n";
    private static final String name = "MaidChan";

    /**
     * Shows the welcome message.
     */
    public void showWelcomeMessage() {
        System.out.println(logo);
        startMessage();
        sendMessage("Hello! I'm " + name + ".\nWhat can I do for you?");
    }

    /**
     * Starts a message.
     */
    public void startMessage() {
        System.out.println("[" + name + "]");
    }

    /**
     * Sends a message to the user.
     *
     * @param messages The messages to send.
     */
    public void sendMessage(List<String> messages) {
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println();
    }

    /**
     * Sends a message to the user.
     *
     * @param message The message to send.
     */
    public void sendMessage(String message) {
        System.out.println(message);
        System.out.println();
    }
}
