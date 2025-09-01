package rio.command;

import rio.TaskList;
import rio.task.Task;

public class MarkCommand {
    private TaskList list;
    private String index;

    public MarkCommand(TaskList list, String index) {
        this.list = list;
        this.index = index;
    }

    public void process() {
        int idx = Integer.parseInt(index);
        if (isValidTaskIndex(idx)) {
            return;
        }

        Task targetedTask = list.getTask(idx - 1);
        targetedTask.markAsDone();
        System.out.println("    Nice! You've got this task done:");
        System.out.println("    " + targetedTask);
    }

    public boolean isValidTaskIndex(int index) {
        if (index <= 0 || index > list.getSize()) {
            System.out.println("    Oops! Please input a valid task index.");
            return true;
        }
        return false;
    }
}
