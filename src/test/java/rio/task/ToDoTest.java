package rio.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoTest {
    @Test
    public void toStringTest() {
        assertEquals("[T][ ] return book", new ToDo("return book").toString());
    }
}
