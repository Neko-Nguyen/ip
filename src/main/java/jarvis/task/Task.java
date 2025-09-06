package jarvis.task;

import java.io.Serializable;

/**
 * Represents a general task that can be marked as finished or
 * unfinished.
 *
 * @author Neko-Nguyen
 */
public class Task implements Serializable {
    private String task;
    private boolean status;

    /**
     * Creates a new Task with description.
     * Initial status is set to unfinished (false).
     *
     * @param task Task description.
     */
    public Task(String task) {
        this.task = task;
        this.status = false;
    }

    /**
     * Gets the description of the task.
     *
     * @return the task description.
     */
    public String get() {
        return task;
    }

    /**
     * Marks as finished.
     */
    public void markAsDone() {
        status = true;
    }

    /**
     * Marks as unfinished.
     */
    public void markAsUndone() {
        status = false;
    }

    public boolean contains(String substring) {
        return task.contains(substring);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task otherTask = (Task) obj;
            String thisTask = this.get();

            if (thisTask == null) {
                return otherTask == null;
            }
            return thisTask.equals(otherTask.get());
        }
        return false;
    }

    @Override
    public String toString() {
        String stat = status ? "X" : " ";
        return "[" + stat + "] " + task;
    }
}
