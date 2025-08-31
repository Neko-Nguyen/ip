package rio.command;

import rio.TaskList;
import rio.task.Task;
import rio.task.ToDo;

/**
 * Represents a command that creates a t-odo task and adds it to the
 * list.
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
     * Processes the command by creating a t-odo task and adding it to
     * the list.
     */
    public void process() {
        Task newTask = new ToDo(task);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
    }
}
