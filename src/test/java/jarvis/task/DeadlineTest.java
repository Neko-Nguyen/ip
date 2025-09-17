package jarvis.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void toStringTest() {
        assertEquals("""
                [D][ ] Submit assignment
                    (by: Sep 30 2025 11:59pm)
                """
                , new Deadline("Submit assignment", "Sep 30 2025 11:59pm").toString());
    }
}
