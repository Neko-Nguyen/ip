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
    private TaskList tasks;
    /** Index of the task to be marked. */
    private String index;
    /** Error message dictionary. */
    private ErrorMessage error;

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
            assert 0 < idx && idx <= this.tasks.getSize()
                    : this.error.getMessage("invalid index");
        } catch (AssertionError e) {
            return e.getMessage();
        }

        Task targetedTask = this.tasks.getTask(idx - 1);
        targetedTask.markAsDone();

        String response = "";

        response += "Mission accomplished, sir. Marking task as complete:\n";
        response += "   " + targetedTask;

        return response;
    }
}
