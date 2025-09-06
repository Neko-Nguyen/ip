package jarvis.command;

import jarvis.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that finds tasks base on the given keyword.
 *
 * @author Neko-Nguyen
 */
public class FindCommand {
    private TaskList list;
    private String keyword;

    /**
     * Creates a FindCommand to find a tasks with matching description.
     *
     * @param list TaskList to search from.
     * @param keyword the keyword to find the tasks with the matching description.
     */
    public FindCommand(TaskList list, String keyword) {
        this.list = list;
        this.keyword = keyword;
    }

    /**
     * Executes the command by searching for the tasks that matches the keyword and
     * displays it to the user.
     */
    public void execute() {
        TaskList searchedList = new TaskList();
        for (int i = 0; i < list.getSize(); ++i) {
            Task task = list.getTask(i);
            if (task.contains(keyword)) {
                searchedList.add(task);
            }
        }

        if (isEmptyList(searchedList)) {
            return;
        }

        System.out.println("    Here are the tasks in your list with your keyword:");
        for (int i = 0; i < searchedList.getSize(); ++i) {
            Task nextTask = searchedList.getTask(i);
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask);
        }
    }

    /**
     * Checks if the given list is empty or not and tells the user if not.
     *
     * @param list the list containing all the searching matches.
     * @return {@code true} when the given list is empty, {@code false} if otherwise.
     */
    public boolean isEmptyList(TaskList list) {
        if (list.isEmpty()) {
            System.out.println("    Oops! Looks like there are no tasks that matches your description");
            return true;
        }
        return false;
    }
}
