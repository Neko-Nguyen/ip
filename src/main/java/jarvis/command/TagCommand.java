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
    private final TaskList tasks;
    /** Description of the tag. */
    private final String description;
    /** Error message dictionary. */
    private final ErrorMessage error;

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

        try {
            this.verifyCommandDescription(parts);

            int idx = Integer.parseInt(parts[0]);
            this.verifyTaskIndex(idx);

            Task targetedTask = this.tasks.getTask(idx - 1);
            targetedTask.addTag(new Tag(parts[1]));

            return this.generateResponse(targetedTask);
        } catch (NumberFormatException e) {
            return this.error.getMessage("invalid index format");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Verifies that the command description contains enough parts.
     *
     * @param parts the split parts of the command description.
     * @throws Exception if the command description is incomplete.
     */
    private void verifyCommandDescription(String[] parts) throws Exception {
        if (parts.length < 2) {
            throw new Exception(this.error.getMessage("missing tag description"));
        }
    }

    /**
     * Verifies that the provided task index is valid.
     *
     * @param idx the task index to verify.
     * @throws Exception if the index is out of bounds.
     */
    private void verifyTaskIndex(int idx) throws Exception {
        if (idx < 1 || idx > this.tasks.getSize()) {
            throw new Exception(this.error.getMessage("invalid index"));
        }
    }

    /**
     * Generates a response message after successfully adding a tag to a task.
     *
     * @param targetedTask the task that was tagged.
     * @return the response message.
     */
    private String generateResponse(Task targetedTask) {
        String response = "";

        response += "Consider it done, sir. Tag successfully applied:\n";
        response += "   " + targetedTask;

        return response;
    }
}
