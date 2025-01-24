package maidchan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import maidchan.ui.Ui;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UiTest {

    @ParameterizedTest
    @ValueSource(strings = {"Test message 1", "OKAY", "Bye! \n Multiline message.", ""})
    public void sendMessage_singleMessage_displaysCorrectMessage(String message) {
        Ui ui = new Ui();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ui.sendMessage(message);

        String expectedOutput = message + "\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void sendMessage_multipleMessages_displaysCorrectMessages() {
        Ui ui = new Ui();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ui.sendMessage(Arrays.asList("Message 1", "OK\nMultiline", ""));

        String expectedOutput = "Message 1\nOK\nMultiline\n\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
