package rio.command;

import rio.TaskList;
import rio.task.Task;

public class DeleteCommand {
    private TaskList list;
    private String index;

    public DeleteCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    public void process() {
        int idx = Integer.parseInt(index);
        if (isValidTaskIndex(idx)) {
            return;
        }

        Task targetedTask = list.getTask(idx - 1);
        list.remove(idx - 1);
        System.out.println("    Sure, I've removed this task:");
        System.out.println("    " + targetedTask);
        System.out.println("    Now you have " + list.getSize() + " task"
                + (list.getSize() == 1 ? "" : "s") + " in your list.");
    }

    public boolean isValidTaskIndex(int index) {
        if (index <= 0 || index > list.getSize()) {
            System.out.println("    Oops! Please input a valid task index.");
            return true;
        }
        return false;
    }
}
