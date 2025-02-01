package maidchan;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import maidchan.command.Command;
import maidchan.exceptions.CommandNotFoundException;
import maidchan.exceptions.TaskException;

public class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"list", "mark 1", "unmark 1", "delete 1", "todo task",
            "deadline task /by 2021-08-24", "event task /from 2021-08-24 /to 2021-08-29"})
    public void parse_validCommand_success(String command) {
        Parser parser = new Parser();
        Command result;
        try {
            result = parser.parseCommand(command);
            assertNotNull(result);
        } catch (CommandNotFoundException | TaskException e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"unknown", "what", "ok", "123 1", ""})
    public void parse_invalidCommand_exceptionThrown(String command) {
        Parser parser = new Parser();
        assertThrows(CommandNotFoundException.class, () -> {
            parser.parseCommand(command);
        });
    }
}
