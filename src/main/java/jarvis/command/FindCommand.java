package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that finds tasks base on the given keyword.
 *
 * @author Neko-Nguyen
 */
public class FindCommand {
    /** List of tasks. */
    private final TaskList list;
    /** Keyword to search for. */
    private final String keyword;
    /** Error message dictionary. */
    private final ErrorMessage error;

    /**
     * Creates a FindCommand to find a tasks with matching description.
     *
     * @param list TaskList to search from.
     * @param keyword the keyword to find the tasks with the matching description.
     */
    public FindCommand(TaskList list, String keyword) {
        this.list = list;
        this.keyword = keyword;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by searching for the tasks that matches the keyword and
     *  displays it to the user.
     *
     * @return the response to the user
     */
    public String execute() {
        TaskList searchedList = new TaskList();
        for (int i = 0; i < this.list.getSize(); ++i) {
            Task task = this.list.getTask(i);
            if (task.doesContain(this.keyword)) {
                searchedList.add(task);
            }
        }

        try {
            if (searchedList.isEmpty()) {
                throw new Exception(this.error.getMessage("no matching searches"));
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return this.generateResponse(searchedList);
    }

    /**
     * Generates the response to be displayed to the user.
     *
     * @param searchedList the list of tasks that matches the keyword.
     * @return the response to be displayed to the user.
     */
    private String generateResponse(TaskList searchedList) {
        String response = "";

        response += "Running scan for keyword matches...\n";
        response += "Search results retrieved, sir:\n";
        for (int i = 0; i < searchedList.getSize(); ++i) {
            Task nextTask = searchedList.getTask(i);
            String num = String.valueOf(i + 1);
            response += num + ". " + nextTask + "\n";
        }

        return response;
    }
}
