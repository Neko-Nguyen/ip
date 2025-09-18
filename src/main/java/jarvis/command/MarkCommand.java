package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that marks a finished task.
 *
 * @author Neko-Nguyen
 */
public class MarkCommand {
    /** List of tasks. */
    private final TaskList tasks;
    /** Index of the task to be marked. */
    private final String index;
    /** Error message dictionary. */
    private final ErrorMessage error;

    /**
     * Creates a MarkCommand to mark a task as finished.
     *
     * @param tasks TaskList to find the task to be marked.
     * @param index index of task to be marked.
     */
    public MarkCommand(TaskList tasks, String index) {
        this.tasks = tasks;
        this.index = index;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the index string and mark
     * the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        int idx = Integer.parseInt(this.index);

        try {
            this.verifyTaskIndex(idx);
        } catch (Exception e) {
            return e.getMessage();
        }

        Task targetedTask = this.tasks.getTask(idx - 1);
        targetedTask.markAsDone();

        return this.generateResponse(targetedTask);
    }

    /**
     * Verifies that the task index is valid.
     *
     * @param idx the index to be verified.
     * @throws Exception if the index is invalid.
     */
    private void verifyTaskIndex(int idx) throws Exception {
        if (idx < 1 || idx > this.tasks.getSize()) {
            throw new Exception(this.error.getMessage("invalid index"));
        }
    }

    /**
     * Generates a response message after marking the task as done.
     *
     * @param targetedTask the task that was marked as done.
     * @return the response message.
     */
    private String generateResponse(Task targetedTask) {
        String response = "";

        response += "Mission accomplished, sir. Marking task as complete:\n";
        response += "   " + targetedTask;

        return response;
    }
}
