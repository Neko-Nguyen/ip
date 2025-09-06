package jarvis;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A converter class to that converts the time from "HHmm" format
 * to "h:mma" format.
 *
 * @author Neko-Nguyen
 */
public class TimeConverter {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HHmm");
    private LocalTime time;


    public TimeConverter(String time) {
        this.time = LocalTime.parse(time, FORMAT);
    }

    /**
     * Returns the time in the "h:mma" format.
     *
     * @return the time string in the "h:mma" format.
     */
    public String convert() {
        return time.format(DateTimeFormatter.ofPattern("h:mma")).toLowerCase();
    }
}
