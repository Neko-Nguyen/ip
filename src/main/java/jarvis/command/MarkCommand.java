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
     *
     * @return the response to the user.
     */
    public String execute() {
        int idx = Integer.parseInt(index);

        try {
            assert 0 < idx && idx <= list.getSize(): getInvalidIndexMessage();
        } catch (AssertionError e) {
            return e.getMessage();
        }

        Task targetedTask = list.getTask(idx - 1);
        targetedTask.markAsDone();

        String response = "";

        response += "Mission accomplished, sir. Marking task as complete:\n";
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
