package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that deletes a specific task from the list.
 *
 * @author Neko-Nguyen
 */
public class DeleteCommand {
    /** List of tasks. */
    private TaskList list;
    /** Index of the task to be deleted. */
    private String index;
    /** Error message dictionary. */
    private ErrorMessage error;

    /**
     * Creates a DeleteCommand to delete a task.
     *
     * @param list TaskList to delete the task from.
     * @param index index of the task to be deleted.
     */
    public DeleteCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the index string and remove
     *  the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        int idx = 0;

        try {
            idx = Integer.parseInt(this.index);
            assert 0 < idx && idx <= this.list.getSize() : this.error.getMessage("invalid index");
        } catch (AssertionError e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return this.error.getMessage("invalid index format");
        }

        Task targetedTask = this.list.getTask(idx - 1);
        this.list.remove(idx - 1);

        String response = "";

        response += "Targeted deletion complete, sir.\n";
        response += "Removed:\n";
        response += "   " + targetedTask;
        response += "The registry now holds " + this.list.getSize() + " active mission"
                + (this.list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }
}
