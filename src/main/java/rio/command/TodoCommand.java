package rio.command;

import rio.TaskList;
import rio.task.Task;
import rio.task.ToDo;

/**
 * Represents a command that creates a t-odo task and adds it to the
 * list.
 *
 * @author Neko-Nguyen
 */
public class TodoCommand {
    private TaskList list;
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
     */
    public void execute() {
        Task newTask = new ToDo(task);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.getSize() + " task"
                + (list.getSize() == 1 ? "" : "s") + " in your list.");
    }
}
