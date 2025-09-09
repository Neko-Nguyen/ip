package jarvis.command;

import jarvis.TaskList;
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

    /**
     * Creates a DeleteCommand to delete a task.
     *
     * @param list TaskList to delete the task from.
     * @param index index of the task to be deleted.
     */
    public DeleteCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    /**
     * Executes the command by parsing the index string and remove
     *  the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        int idx = Integer.parseInt(this.index);

        try {
            assert 0 < idx && idx <= this.list.getSize()
                    : this.getInvalidIndexMessage();
        } catch (AssertionError e) {
            return e.getMessage();
        }

        Task targetedTask = this.list.getTask(idx - 1);
        this.list.remove(idx - 1);

        String response = "";

        response += "Targeted deletion complete, sir.\n";
        response += "Removed:\n";
        response += "   " + targetedTask + "\n";
        response += "The registry now holds " + this.list.getSize() + " active mission"
                + (this.list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }

    /**
     * Returns the message shown when the input index is invalid.
     *
     * @return invalid index message.
     */
    public String getInvalidIndexMessage() {
        return "Sir, that index does not compute. Please provide a valid task identifier.\n";
    }
}
