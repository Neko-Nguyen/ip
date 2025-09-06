package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that list out all the tasks in the list.
 *
 * @author Neko-Nguyen
 */
public class ListCommand {
    private TaskList list;

    /**
     * Creates a ListCommand to list out all the tasks.
     *
     * @param list TaskList to list the task from.
     */
    public ListCommand(TaskList list) {
        this.list = list;
    }

    /**
     * Executes the command by listing out all the tasks in the
     * list.
     */
    public void execute() {
        if (isEmptyList()) {
            return;
        }

        System.out.println("    Here are all the tasks in your list:");
        for (int i = 0; i < list.getSize(); ++i) {
            Task nextTask = list.getTask(i);
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask);
        }
    }

    /**
     * Checks if the list is empty or not and prints the message to let
     * user know.
     *
     * @return {@code true} when the list is empty, {@code false} if otherwise.
     */
    public boolean isEmptyList() {
        if (list.isEmpty()) {
            System.out.println("    Oops! Looks like there are no tasks in your list. ^^");
            return true;
        }
        return false;
    }
}
