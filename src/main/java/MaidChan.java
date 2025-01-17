public class MaidChan {
    public static void main(String[] args) {
        String logo = " __  __       _     _  ____ _\n"
                    + "|  \\/  | __ _(_) __| |/ ___| |__   __ _ _ __\n"
                    + "| |\\/| |/ _` | |/ _` | |   | '_ \\ / _` | '_ \\\n"
                    + "| |  | | (_| | | (_| | |___| | | | (_| | | | |\n"
                    + "|_|  |_|\\__,_|_|\\__,_|\\____|_| |_|\\__,_|_| |_|\n";
        String name = "MaidChan";

        printHorizontalLine();
        System.out.println("Hello! I'm " + name);
        System.out.println("What can I do for you?");
        printHorizontalLine();
        System.out.println("Bye. Hope to see you again soon!");
        printHorizontalLine();
    }

    private static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
    }
}
