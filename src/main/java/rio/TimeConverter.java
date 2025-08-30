package rio;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HHmm");
    private LocalTime time;

    public TimeConverter(String time) {
        this.time = LocalTime.parse(time, FORMAT);
    }

    public String convert() {
        return time.format(DateTimeFormatter.ofPattern("h:mma")).toLowerCase();
    }
}
