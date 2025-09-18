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
    private final TaskList list;
    /** Index of the task to be deleted. */
    private final String index;
    /** Error message dictionary. */
    private final ErrorMessage error;

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
        try {
            int idx = Integer.parseInt(this.index);
            this.verifyTaskIndex(idx);

            Task targetedTask = this.list.getTask(idx - 1);
            this.list.remove(idx - 1);

            return this.generateResponse(targetedTask);
        } catch (NumberFormatException e) {
            return this.error.getMessage("invalid index format");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Verifies that the provided task index is valid.
     *
     * @param idx the index to verify.
     * @throws Exception if the index is out of bounds.
     */
    private void verifyTaskIndex(int idx) throws Exception {
        if (idx < 1 || idx > this.list.getSize()) {
            throw new Exception(this.error.getMessage("invalid task index"));
        }
    }

    /**
     * Generates a response message after successfully deleting a task.
     *
     * @param targetedTask the task that was deleted.
     * @return the response message.
     */
    private String generateResponse(Task targetedTask) {
        String response = "";

        response += "Targeted deletion complete, sir.\n";
        response += "Removed:\n";
        response += "   " + targetedTask;
        response += "The registry now holds " + this.list.getSize() + " active mission"
                + (this.list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }
}
