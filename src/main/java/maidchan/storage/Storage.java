package maidchan.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import maidchan.exceptions.MaidChanUnexpectedException;
import maidchan.exceptions.TaskException;
import maidchan.task.Deadline;
import maidchan.task.Event;
import maidchan.task.Task;
import maidchan.task.ToDo;

/**
 * Handles the loading and saving of tasks to a file.
 */
public class Storage {
    private final File file;

    /**
     * Constructs a new Storage with the specified file path.
     *
     * @param filePath the path to the file
     */
    public Storage(String filePath) {
        file = new File(filePath);
    }

    /**
     * Loads the todo list from the file.
     * If the file does not exist, an empty list is returned.
     *
     * @return the list of tasks
     */
    public ArrayList<Task> loadTodoList() {
        ArrayList<Task> tasks = new ArrayList<>();

        if (!file.exists()) {
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Task task = getTask(scanner.nextLine());
                tasks.add(task);
            }
        } catch (IOException | TaskException e) {
            System.out.println("An error occurred while loading the todo list: " + e.getMessage());
        }

        return tasks;
    }

    private static Task getTask(String line) throws TaskException {
        String[] parts = line.split(" ", 3);
        boolean isDone = parts[0].equals("1");
        String command = parts[1];
        String description = parts[2];

        Task task;
        switch (command) {
        case ToDo.COMMAND_NAME:
            task = new ToDo(description);
            break;
        case Deadline.COMMAND_NAME:
            task = new Deadline(description);
            break;
        case Event.COMMAND_NAME:
            task = new Event(description);
            break;
        default:
            throw new MaidChanUnexpectedException(
                    "Unknown task type when loading file: " + command);
        }

        if (isDone) {
            task.mark();
        }
        return task;
    }

    /**
     * Saves the todo list to the file.
     * If the file does not exist, it will be created.
     *
     * @param tasks the list of tasks to save
     */
    public void saveTodoList(List<Task> tasks) {
        file.getParentFile().mkdirs(); // Create directories if they do not exist

        try (FileWriter writer = new FileWriter(file)) {
            for (Task task : tasks) {
                writer.write(task.toRepr() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the todo list: " + e.getMessage());
        }
    }
}
