package rio.command;

import rio.TaskList;
import rio.task.Task;

public class UnmarkCommand {
    private TaskList list;
    private String index;

    public UnmarkCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    public void process() {
        int idx = Integer.parseInt(index);
        if (isValidTaskIndex(idx)) return;

        Task targetedTask = list.get(idx - 1);
        targetedTask.unfinish();
        System.out.println("    Ok, I've marked this task as not done yet:");
        System.out.println("    " + targetedTask);
    }

    public boolean isValidTaskIndex(int index) {
        if (index <= 0 || index > list.size()) {
            System.out.println("    Oops! Please input a valid task index.");
            return true;
        }
        return false;
    }
}
