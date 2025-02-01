package maidchan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import maidchan.exceptions.TaskException;
import maidchan.task.Task;

public class TaskTest {

    @ParameterizedTest
    @ValueSource(strings = {"Read book", "Write code", "Attend meeting"})
    public void constructor_validDescription_success(String description) {
        try {
            Task task = new Task(description);
            assertEquals(description, task.toString().substring(4));
        } catch (TaskException e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    public void constructor_emptyDescription_exceptionThrown(String description) {
        assertThrows(TaskException.class, () -> {
            new Task(description);
        });
    }

    @Test
    public void mark_taskMarkedAsDone() {
        try {
            Task task = new Task("Test task");
            task.mark();
            assertTrue(task.toString().contains("[X]"));
        } catch (TaskException e) {
            fail();
        }
    }

    @Test
    public void unmark_taskMarkedAsNotDone() {
        try {
            Task task = new Task("Test task");
            task.mark();
            assertTrue(task.toString().contains("[X]"));
            task.unmark();
            assertTrue(task.toString().contains("[ ]"));
        } catch (TaskException e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Read book", "Write code", "Attend meeting"})
    public void toString_formatIsCorrect(String description) {
        try {
            Task task = new Task(description);
            assertEquals("[ ] " + description, task.toString());
            task.mark();
            assertEquals("[X] " + description, task.toString());
            task.unmark();
            assertEquals("[ ] " + description, task.toString());
        } catch (TaskException e) {
            fail();
        }
    }
}
