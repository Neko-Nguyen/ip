package jarvis.command;

import java.time.format.DateTimeParseException;

import jarvis.converter.DateConverter;
import jarvis.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.converter.TimeConverter;
import jarvis.task.Deadline;
import jarvis.task.Task;

/**
 * Represents a command that creates a deadline task and add it to the
 *  list.
 *
 * @author Neko-Nguyen
 */
public class DeadlineCommand {
    /** List of tasks. */
    private final TaskList list;
    /** Deadline task. */
    private final String task;
    /** Error message dictionary. */
    private final ErrorMessage error;

    /**
     * Creates a DeadlineCommand to add a deadline task.
     *
     * @param list TaskList to add the task to.
     * @param task Deadline task description (format: "task /by deadline").
     */
    public DeadlineCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the deadline date/time, creating a
     *  new deadline task and adding it to the list.
     *
     * @return the response to the user.
     */
    public String execute() {
        try {
            String[] parts = this.task.split("/");
            this.verifyCommandDescription(parts);

            String[] deadline = parts[1].split(" ");
            this.verifyDateTimeDescription(deadline);
            this.verifyDateTimeCode(deadline[0]);

            String deadlineDate = new DateConverter(deadline[1]).convert();
            String deadlineTime = new TimeConverter(deadline[2]).convert();

            Task newTask = new Deadline(parts[0], deadlineDate + " " + deadlineTime);
            this.list.add(newTask);

            return this.generateResponse(newTask);
        } catch (DateTimeParseException e) {
            return this.error.getMessage("invalid datetime format");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Verifies that the command has a valid description.
     *
     * @param parts the parts of the command split by "/".
     * @throws Exception if the description is missing.
     */
    private void verifyCommandDescription(String[] parts) throws Exception {
        if (parts.length < 2) {
            throw new Exception(this.error.getMessage("missing task description"));
        }
    }

    /**
     * Verifies that the date/time description is complete.
     *
     * @param datetime the date/time description split by spaces.
     * @throws Exception if the description is incomplete.
     */
    private void verifyDateTimeDescription(String[] datetime) throws Exception {
        if (datetime.length < 3) {
            throw new Exception(this.error.getMessage("missing datetime description"));
        }
    }

    /**
     * Verifies that the date/time code is correct.
     *
     * @param code the date/time code to verify.
     * @throws Exception if the code is invalid.
     */
    private void verifyDateTimeCode(String code) throws Exception {
        if (!code.equals("by")) {
            throw new Exception(this.error.getMessage("invalid deadline datetime code"));
        }
    }

    /**
     * Generates a response message after adding a new task.
     *
     * @param newTask the newly added task.
     * @return the response message.
     */
    private String generateResponse(Task newTask) {
        String response = "";

        response += "Protocol initiated. Task archived:\n";
        response += "   " + newTask;
        response += "Sir, the list now doesContain " + this.list.getSize() + " active mission"
                + (this.list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }
}
