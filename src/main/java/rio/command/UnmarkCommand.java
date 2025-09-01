package rio.command;

import rio.TaskList;
import rio.task.Task;

/**
 * Represents a command that unmark an unfinished task.
 * @author Neko-Nguyen
 */
public class UnmarkCommand {
    private TaskList list;
    private String index;

    public UnmarkCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    /**
     * Processes the command by parsing the index string and unmark
     * the indicated task.
     */
    public void process() {
        int idx = Integer.parseInt(index);
        if (isValidTaskIndex(idx)) {
            return;
        }

        Task targetedTask = list.getTask(idx - 1);
        targetedTask.markAsUndone();
        System.out.println("    Ok, I've marked this task as not done yet:");
        System.out.println("    " + targetedTask);
    }

    /**
     * Checks if the given index is valid.
     * @param index the index of a specific task.
     * @return {@code true} when the index is valid, {@code false}
     * if otherwise.
     */
    public boolean isValidTaskIndex(int index) {
        if (index <= 0 || index > list.getSize()) {
            System.out.println("    Oops! Please input a valid task index.");
            return true;
        }
        return false;
    }
}
