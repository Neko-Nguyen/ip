package rio.command;

import rio.TaskList;
import rio.task.Task;

public class ListCommand {
    private TaskList list;

    public ListCommand(TaskList list) {
        this.list = list;
    }

    public void process() {
        if (isEmptyList()) return;

        System.out.println("    Here are all the tasks in your list:");
        for (int i = 0; i < list.size(); ++i) {
            Task nextTask = list.get(i);
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask);
        }
    }

    public boolean isEmptyList() {
        if (list.isEmpty()) {
            System.out.println("    Oops! Looks like there are no tasks in your list. ^^");
            return true;
        }
        return false;
    }
}
