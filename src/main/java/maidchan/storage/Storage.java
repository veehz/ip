package maidchan.storage;

import maidchan.exceptions.MaidChanUnexpectedException;
import maidchan.exceptions.TaskException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import maidchan.task.Deadline;
import maidchan.task.Event;
import maidchan.task.Task;
import maidchan.task.ToDo;

public class Storage {
    private File file;

    public Storage(String filePath) {
        file = new File(filePath);
    }

    public ArrayList<Task> loadTodoList() {
        ArrayList<Task> tasks = new ArrayList<>();

        if (!file.exists()) {
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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

                tasks.add(task);
            }
        } catch (IOException | TaskException e) {
            System.out.println("An error occurred while loading the todo list: " + e.getMessage());
        }

        return tasks;
    }

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
