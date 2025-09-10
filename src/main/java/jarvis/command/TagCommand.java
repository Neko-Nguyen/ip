package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.tag.Tag;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that adds a tag to a specific task.
 *
 * @author Neko-Nguyen
 */
public class TagCommand {
    /** List of tasks. */
    private TaskList tasks;
    /** Description of the tag. */
    private String description;
    /** Error message dictionary. */
    private ErrorMessage error;

    /**
     * Creates a TagCommand to add a tag to a task.
     *
     * @param tasks task list to find the task to be tagged.
     * @param description description of the tag.
     */
    public TagCommand(TaskList tasks, String description) {
        this.tasks = tasks;
        this.description = description;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the index string, creating a tag and
     *  adding it to the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        String[] parts = this.description.split("/");
        int idx = 0;

        try {
            assert parts.length > 1 : this.error.getMessage("missing tag description");
            idx = Integer.parseInt(parts[0]);
            assert 0 < idx && idx <= this.tasks.getSize() : this.error.getMessage("invalid index");
        } catch (AssertionError e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return this.error.getMessage("invalid index format");
        }

        Task targetedTask = this.tasks.getTask(idx - 1);
        targetedTask.addTag(new Tag(parts[1]));

        String response = "";

        response += "Consider it done, sir. Tag successfully applied:\n";
        response += "   " + targetedTask;

        return response;
    }
}
