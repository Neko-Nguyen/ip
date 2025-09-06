package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that unmark an unfinished task.
 *
 * @author Neko-Nguyen
 */
public class UnmarkCommand {
    private TaskList list;
    private String index;

    /**
     * Creates a UnmarkCommand to mark a task as unfinished.
     *
     * @param list TaskList to find the task to be unmarked.
     * @param index index of task to be unmarked.
     */
    public UnmarkCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    /**
     * Executes the command by parsing the index string and unmark
     *  the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        int idx = Integer.parseInt(index);
        if (idx <= 0 || idx > list.getSize()) {
            return getInvalidIndexMessage();
        }

        Task targetedTask = list.getTask(idx - 1);
        targetedTask.markAsUndone();

        String response = "";

        response += "Status update: Task reverted to pending, sir.\n";
        response += "   " + targetedTask + "\n";

        return response;
    }

    /**
     * Returns the message shown when the input index is invalid.
     *
     * @return invalid index message.
     */
    public String getInvalidIndexMessage() {
        return "Sir, that index is not within the operational parameters.\n"
                + "Please specify a valid task identifier.\n";
    }
}
