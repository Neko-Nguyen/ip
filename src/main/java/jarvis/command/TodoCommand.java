package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;
import jarvis.task.ToDo;

/**
 * Represents a command that creates a t-odo task and adds it to the
 * list.
 *
 * @author Neko-Nguyen
 */
public class TodoCommand {
    private TaskList list;
    private String task;

    public TodoCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
    }

    /**
     * Executes the command by creating a t-odo task and adding it to
     * the list.
     *
     * @return the reponse to the user.
     */
    public String execute() {
        Task newTask = new ToDo(task);
        list.add(newTask);

        String response = "";

        response += "Protocol initiated. Task archived:\n";
        response += "   " + newTask + "\n";
        response += "Sir, the list now contains " + list.getSize() + " active mission"
                + (list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }
}
