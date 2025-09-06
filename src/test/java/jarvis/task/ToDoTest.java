package jarvis.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void toStringTest() {
        assertEquals("[T][ ] return book", new ToDo("return book").toString());
    }
}
