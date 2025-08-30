package rio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DateConverter {
    private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT);
    private LocalDate date;

    public DateConverter(String date) {
        this.date = LocalDate.parse(date, FORMAT);
    }

    public String convert() {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}
