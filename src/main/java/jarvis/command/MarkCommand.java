package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that marks a finished task.
 *
 * @author Neko-Nguyen
 */
public class MarkCommand {
    private TaskList list;
    private String index;

    /**
     * Creates a MarkCommand to mark a task as finished.
     *
     * @param list TaskList to find the task to be marked.
     * @param index index of task to be marked.
     */
    public MarkCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    /**
     * Executes the command by parsing the index string and mark
     * the indicated task.
     */
    public void execute() {
        int idx = Integer.parseInt(index);
        if (isValidTaskIndex(idx)) {
            return;
        }

        Task targetedTask = list.getTask(idx - 1);
        targetedTask.markAsDone();
        System.out.println("    Nice! You've got this task done:");
        System.out.println("    " + targetedTask);
    }

    /**
     * Checks if the given index is valid.
     *
     * @param index the index of a specific task.
     * @return {@code true} when the index is valid, {@code false} if otherwise.
     */
    public boolean isValidTaskIndex(int index) {
        if (index <= 0 || index > list.getSize()) {
            System.out.println("    Oops! Please input a valid task index.");
            return true;
        }
        return false;
    }
}
