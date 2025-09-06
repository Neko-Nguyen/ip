package jarvis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * A converter class to that converts the date from "uuuu-MM-dd" format
 * to "MMM d yyyy" format.
 *
 * @author Neko-Nguyen
 */
public class DateConverter {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT);
    private LocalDate date;

    public DateConverter(String date) {
        this.date = LocalDate.parse(date, FORMAT);
    }

    /**
     * Returns the date in the "MMM d yyyy" format.
     *
     * @return the date string in the "MMM d yyyy" format
     */
    public String convert() {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}
