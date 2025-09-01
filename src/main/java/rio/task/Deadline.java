package rio.task;

/**
 * Represents a task with a specific deadline.
 * @author Neko-Nguyen
 */
public class Deadline extends Task {
    private String deadline;

    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return obj instanceof Deadline;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}
