package jarvis.task;

/**
 * Represents a event task.
 *
 * @author Neko-Nguyen
 */
public class Event extends Task {
    /** Event start description. */
    private String start;
    /** Event end description. */
    private String end;

    /**
     * Creates an Event task with description, start and end.
     *
     * @param task Task description.
     * @param start start date and time.
     * @param end end date and time.
     */
    public Event(String task, String start, String end) {
        super(task);
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return obj instanceof Event;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: " + this.start + " to: " + this.end + ")";
    }
}
