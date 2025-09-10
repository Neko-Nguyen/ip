package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that list out all the tasks in the list.
 *
 * @author Neko-Nguyen
 */
public class ListCommand {
    /** List of tasks. */
    private TaskList list;
    /** Error message dictionary. */
    private ErrorMessage error;

    /**
     * Creates a ListCommand to list out all the tasks.
     *
     * @param list TaskList to list the task from.
     */
    public ListCommand(TaskList list) {
        this.list = list;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by listing out all the tasks in the
     *  list.
     *
     * @return the response to the user.
     */
    public String execute() {
        try {
            assert !this.list.isEmpty() : this.error.getMessage("empty task list");
        } catch (AssertionError e) {
            return e.getMessage();
        }

        String response = "";

        response += "Compiling full mission log, sir.\n";
        response += "// Displaying All Active Protocols //\n";
        for (int i = 0; i < this.list.getSize(); ++i) {
            Task nextTask = this.list.getTask(i);
            String num = String.valueOf(i + 1);
            response += num + ". " + nextTask;
        }

        return response;
    }
}
