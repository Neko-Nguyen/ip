package jarvis.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoTest {
    @Test
    public void toStringTest() {
        assertEquals("""
                [T][ ] Read Chapter 5 of Database Systems
                """
                , new ToDo("Read Chapter 5 of Database Systems").toString());
    }
}
