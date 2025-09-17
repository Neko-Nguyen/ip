package jarvis.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Mimics an ArrayList to stores the tasks in an array.
 *
 * @author Neko-Nguyen
 */
public class TaskList implements Serializable {
    /** List of tasks. */
    private final List<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list.
     */
    public int getSize() {
        return this.list.size();
    }

    /**
     * Returns the task in the place of the given index.
     *
     * @param index the index of the wanted task.
     * @return the task in the place of the given index.
     */
    public Task getTask(int index) {
        return this.list.get(index);
    }

    /**
     * Adds the given task to the list.
     *
     * @param task the task to be added to the list.
     */
    public void add(Task task) {
        this.list.add(task);
    }

    /**
     * Removes the task in the place of the given index.
     *
     * @param index the index of the task to be removed.
     */
    public void remove(int index) {
        this.list.remove(index);
    }

    /**
     * Checks if the list doesContain no elements.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
