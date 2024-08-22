import GUIs.StartGUI;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StartGUITest {

    StartGUI tester = new StartGUI();

    @Test
    void driver() {
    }

    @Test
    void admin() {
    }

    @Test
    void start() {
    }

    @Test
    void main() {
    }

    @Test
    void jobToTable() {
    }

    @Test
    void toNotesFormat() {
        String test = "Load is 12 inches wider than normal!";
        String Expected = "Load is 12 inches wider\nthan normal!";

        int space = 25;

        assertEquals(Expected, tester.toNotesFormat(test, space), "Text is not valid for diplay!" );

    }


}