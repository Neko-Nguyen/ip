package jarvis.command;

import jarvis.task.TaskList;
import jarvis.task.Task;
import jarvis.task.ToDo;

/**
 * Represents a command that creates a t-odo task and adds it to the
 * list.
 *
 * @author Neko-Nguyen
 */
public class TodoCommand {
    /** List of tasks. */
    private TaskList list;
    /** Normal task. */
    private String task;

    /**
     * Creates a TodoCommand to add a t-odo task.
     *
     * @param list TaskList to add the task to.
     * @param task T-odo task description.
     */
    public TodoCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
    }

    /**
     * Executes the command by creating a t-odo task and adding it to
     *  the list.
     *
     * @return the response to the user.
     */
    public String execute() {
        Task newTask = new ToDo(this.task);
        this.list.add(newTask);

        String response = "";

        response += "Protocol initiated. Task archived:\n";
        response += "   " + newTask;
        response += "Sir, the list now doesContain " + this.list.getSize() + " active mission"
                + (this.list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }
}
