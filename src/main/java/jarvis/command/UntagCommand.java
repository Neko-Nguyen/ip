package jarvis.command;

import jarvis.ErrorMessage;
import jarvis.tag.Tag;
import jarvis.task.TaskList;
import jarvis.task.Task;

/**
 * Represents a command that removes a tag from a specific task.
 *
 * @author Neko-Nguyen
 */
public class UntagCommand {
    /** List of tasks. */
    private final TaskList tasks;
    /** Description of the tag. */
    private final String description;
    /** Error message dictionary. */
    private final ErrorMessage error;

    /**
     * Creates a UntagCommand to removes a tag from a task.
     *
     * @param tasks task list to find the task to be untagged.
     * @param description description of the command.
     */
    public UntagCommand(TaskList tasks, String description) {
        this.tasks = tasks;
        this.description = description;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the input string to extract the task index and tag,
     *  then removes the specified tag from the indicated task.
     *
     * @return the response to the user.
     */
    public String execute() {
        String[] parts = this.description.split("/");

        try {
            this.verifyCommandDescription(parts);

            int taskIdx = Integer.parseInt(parts[0]);
            int tagIdx = Integer.parseInt(parts[1]);

            this.verifyTaskIndex(taskIdx);
            Task targetedTask = this.tasks.getTask(taskIdx - 1);

            this.verifyTagIndex(tagIdx, targetedTask);
            targetedTask.removeTag(tagIdx - 1);

            return this.generateResponse(targetedTask);
        } catch (NumberFormatException e) {
            return this.error.getMessage("invalid index format");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Verifies if the command description has enough parts.
     *
     * @param parts the split command description.
     * @throws Exception if the description is incomplete.
     */
    private void verifyCommandDescription(String[] parts) throws Exception {
        if (parts.length < 2) {
            throw new Exception(this.error.getMessage("missing tag description"));
        }
    }

    /**
     * Verifies if the given task index is valid.
     *
     * @param index the index to be verified.
     * @throws Exception if the index is invalid.
     */
    private void verifyTaskIndex(int index) throws Exception {
        if (index < 1 || index > this.tasks.getSize()) {
            throw new Exception(this.error.getMessage("invalid task index"));
        }
    }

    /**
     * Verifies if the given tag index is valid for the specified task.
     *
     * @param index the index to be verified.
     * @param targetedTask the task to check the tag index against.
     * @throws Exception if the index is invalid.
     */
    private void verifyTagIndex(int index, Task targetedTask) throws Exception {
        if (index < 1 || index > targetedTask.getNumOfTags()) {
            throw new Exception(this.error.getMessage("invalid tag index"));
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
