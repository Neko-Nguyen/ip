package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that list out all the tasks in the list.
 *
 * @author Neko-Nguyen
 */
public class ListCommand {
    /** List of tasks. */
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
     *  list.
     *
     * @return the response to the user.
     */
    public String execute() {
        if (this.list.isEmpty()) {
            return this.getEmptyTaskListMessage();
        }

        String response = "";

        response += "Compiling full mission log, sir.\n";
        response += "// Displaying All Active Protocols //\n";
        for (int i = 0; i < this.list.getSize(); ++i) {
            Task nextTask = this.list.getTask(i);
            String num = String.valueOf(i + 1);
            response += num + ". " + nextTask + "\n";
        }

        return response;
    }

    /**
     * Returns the message shown when the task list is empty.
     *
     * @return empty task list message.
     */
    public String getEmptyTaskListMessage() {
        return "Sir, the mission log is currently clear.\n"
                + "No active protocols are queued for execution.\n";
    }
}
