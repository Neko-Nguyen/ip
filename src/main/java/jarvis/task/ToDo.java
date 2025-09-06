package jarvis.task;

/**
 * Represents a normal task.
 *
 * @author Neko-Nguyen
 */
public class ToDo extends Task {

    /**
     * Creates a T-odo task with description.
     *
     * @param task Task description.
     */
    public ToDo(String task) {
        super(task);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return obj instanceof ToDo;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
