package rio.task;

public class Event extends Task {
    private String start;
    private String end;

    public Event(String task, String start, String end) {
        super(task);
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (obj instanceof Event) return true;
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + start + " to: " + end + ")";
    }
}
