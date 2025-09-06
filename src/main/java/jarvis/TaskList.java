package jarvis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jarvis.task.Task;

/**
 * Mimics an ArrayList to stores the tasks in an array.
 *
 * @author Neko-Nguyen
 */
public class TaskList implements Serializable {
    private List<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns the task in the place of the given index.
     *
     * @param index the index of the wanted task.
     * @return the task in the place of the given index.
     */
    public Task getTask(int index) {
        return list.get(index);
    }

    /**
     * Adds the given task to the list.
     *
     * @param task the task to be added to the list.
     */
    public void add(Task task) {
        list.add(task);
    }

    /**
     * Removes the task in the place of the given index.
     *
     * @param index the index of the task to be removed.
     */
    public void remove(int index) {
        list.remove(index);
    }

    /**
     * Checks if the list contains no elements.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
