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
    private final TaskList list;
    /** Error message dictionary. */
    private final ErrorMessage error;

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
            if (this.list.isEmpty()) {
                throw new Exception(this.error.getMessage("empty task list"));
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return this.generateResponse();
    }

    /**
     * Generates the response to be displayed to the user.
     *
     * @return the response to be displayed to the user.
     */
    private String generateResponse() {
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
