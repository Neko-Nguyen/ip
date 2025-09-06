package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;

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
     *
     * @return the response to the user.
     */
    public String execute() {
        int idx = Integer.parseInt(index);
        if (idx <= 0 || idx > list.getSize()) {
            return getInvalidIndexMessage();
        }

        Task targetedTask = list.getTask(idx - 1);
        list.remove(idx - 1);

        String response = "";

        response += "Targeted deletion complete, sir.\n";
        response += "Removed:\n";
        response += "   " + targetedTask + "\n";
        response += "The registry now holds " + list.getSize() + " active mission"
                + (list.getSize() == 1 ? "" : "s") + ".\n";

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
