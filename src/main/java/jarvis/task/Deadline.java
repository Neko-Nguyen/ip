package jarvis.task;

/**
 * Represents a task with a specific deadline.
 *
 * @author Neko-Nguyen
 */
public class Deadline extends Task {
    /** Deadline description. */
    private final String deadline;

    /**
     * Creates a Deadline task with description and deadline.
     *
     * @param task Task description.
     * @param deadline Deadline date and time.
     */
    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString()
                + "    (by: " + this.deadline + ")\n";
    }
}
