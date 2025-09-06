package jarvis.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void toStringTest() {
        assertEquals("[D][ ] return book (by: 2025 Oct 12)",
                new Deadline("return book", "2025 Oct 12").toString());
    }
}
