package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that unmark an unfinished task.
 *
 * @author Neko-Nguyen
 */
public class UnmarkCommand {
    /** List of tasks. */
    private final TaskList list;
    /** Index of the task to be umarked. */
    private final String index;
    /** Error message dictionary. */
    private final ErrorMessage error;

    /**
     * Creates a UnmarkCommand to mark a task as unfinished.
     *
     * @param list TaskList to find the task to be unmarked.
     * @param index index of task to be unmarked.
     */
    public UnmarkCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the index string and unmark
     *  the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        try {
            int idx = Integer.parseInt(this.index);
            assert 0 < idx && idx <= this.list.getSize() : this.error.getMessage("invalid index");

            Task targetedTask = this.list.getTask(idx - 1);
            targetedTask.markAsUndone();

            return this.generateResponse(targetedTask);
        } catch (AssertionError e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return this.error.getMessage("invalid index format");
        }
    }

    /**
     * Generates a response message after successfully unmarking a task.
     *
     * @param targetedTask the task that was unmarked.
     * @return the response message.
     */
    private String generateResponse(Task targetedTask) {
        String response = "";

        response += "Status update: Task reverted to pending, sir.\n";
        response += "   " + targetedTask;

        return response;
    }
}
