package rio.command;

import rio.TaskList;
import rio.task.Task;

/**
 * Represents a command that finds tasks base on the given keyword.
 * @author Neko-Nguyen
 */
public class FindCommand {
    private TaskList list;
    private String keyword;

    public FindCommand(TaskList list, String keyword) {
        this.list = list;
        this.keyword = keyword;
    }

    /**
     * Processes the command by searching for the tasks that matches the keyword and
     * displays it to the user.
     */
    public void process() {
        TaskList searchedList = new TaskList();
        for (int i = 0; i < list.size(); ++i) {
            Task task = list.get(i);
            if (task.contains("book")) {
                searchedList.add(task);
            }
        }

        if (isEmptyList(searchedList)) return;

        System.out.println("    Here are the tasks in your list with your keyword:");
        for (int i = 0; i < searchedList.size(); ++i) {
            Task nextTask = searchedList.get(i);
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask);
        }
    }

    /**
     * Checks if the given list is empty or not and tells the user if not.
     * @param list the list containing all the searching matches.
     * @return {@code true} when the given list is empty, {@code false} if
     * otherwise.
     */
    public boolean isEmptyList(TaskList list) {
        if (list.isEmpty()) {
            System.out.println("    Oops! Looks like there are no tasks that matches your description");
            return true;
        }
        return false;
    }
}
