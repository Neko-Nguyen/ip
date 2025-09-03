package rio.command;

import rio.TaskList;
import rio.task.Task;

/**
 * Represents a command that deletes a specific task from the list.
 *
 * @author Neko-Nguyen
 */
public class DeleteCommand {
    private TaskList list;
    private String index;

    public DeleteCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    /**
     * Executes the command by parsing the index string and remove
     * the indicated task.
     */
    public void execute() {
        int idx = Integer.parseInt(index);
        if (isValidTaskIndex(idx)) {
            return;
        }

        Task targetedTask = list.getTask(idx - 1);
        list.remove(idx - 1);
        System.out.println("    Sure, I've removed this task:");
        System.out.println("    " + targetedTask);
        System.out.println("    Now you have " + list.getSize() + " task"
                + (list.getSize() == 1 ? "" : "s") + " in your list.");
    }

    /**
     * Checks if the given index is valid and let the user know if not.
     *
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
