package rio.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class DeadlineTest {
    @Test
    public void toStringTest() {
        assertEquals("[D][ ] return book (by: 2025 Oct 12)",
                new Deadline("return book", "2025 Oct 12").toString());
    }
}
