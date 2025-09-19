package jarvis.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A converter class to that converts the time from "HHmm" format
 * to "h:mma" format.
 *
 * @author Neko-Nguyen
 */
public class TimeConverter {
    /** Output time format. */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("HHmm");
    /** Time of the day. */
    private final LocalTime time;

    public TimeConverter(String time) {
        this.time = LocalTime.parse(time, FORMAT);
    }

    /**
     * Returns the LocalTime object.
     *
     * @return the LocalTime object
     */
    public LocalTime getTime() {
        return this.time;
    }

    /**
     * Returns the time in the "h:mma" format.
     *
     * @return the time string in the "h:mma" format.
     */
    public String convert() {
        return this.time.format(DateTimeFormatter.ofPattern("h:mma")).toLowerCase();
    }
}
