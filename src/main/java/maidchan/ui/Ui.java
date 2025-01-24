package maidchan.ui;

import java.util.List;

public class Ui {
    private static final String logo = "" //
            + " __  __       _     _  ____ _\n" //
            + "|  \\/  | __ _(_) __| |/ ___| |__   __ _ _ __\n"
            + "| |\\/| |/ _` | |/ _` | |   | '_ \\ / _` | '_ \\\n"
            + "| |  | | (_| | | (_| | |___| | | | (_| | | | |\n"
            + "|_|  |_|\\__,_|_|\\__,_|\\____|_| |_|\\__,_|_| |_|\n";
    private static final String name = "MaidChan";

    public void showWelcomeMessage() {
        System.out.println(logo);
        startMessage();
        sendMessage("Hello! I'm " + name + ".\nWhat can I do for you?");
    }

    public void startMessage() {
        System.out.println("[" + name + "]");
    }

    public void sendMessage(List<String> messages) {
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println();
    }

    public void sendMessage(String message) {
        System.out.println(message);
        System.out.println();
    }
}
