package jarvis.command;

import java.time.format.DateTimeParseException;

import jarvis.converter.DateConverter;
import jarvis.ui.ErrorMessage;
import jarvis.task.TaskList;
import jarvis.converter.TimeConverter;
import jarvis.task.Event;
import jarvis.task.Task;

/**
 * Represents a command that creates an event task and adds it
 * to the list.
 *
 * @author Neko-Nguyen
 */
public class EventCommand {
    /** List of tasks. */
    private final TaskList list;
    /** Event task. */
    private final String task;
    /** Error message dictionary. */
    private final ErrorMessage error;

    /**
     * Creates a EventCommand to add an event task.
     *
     * @param list TaskList to add the task to
     * @param task Event task description (format: task /from start /to end )
     */
    public EventCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
        this.error = new ErrorMessage();
    }

    /**
     * Executes the command by parsing the start and end date/time, creating
     *  a new event task and adding it to the list.
     *
     * @return the response to the user.
     */
    public String execute() {
        try {
            String[] parts = this.task.split("/");
            this.verifyCommandDescription(parts);

            String[] start = parts[1].split(" ");
            String[] end = parts[2].split(" ");

            this.verifyDateTimeDescription(start);
            this.verifyDateTimeDescription(end);
            this.verifyDateTimeCode(start[0], end[0]);

            String startDate = new DateConverter(start[1]).convert();
            String startTime = new TimeConverter(start[2]).convert();
            String endDate = new DateConverter(end[1]).convert();
            String endTime = new TimeConverter(end[2]).convert();

            Task newTask = new Event(parts[0], startDate + " " + startTime,
                                            endDate + " " + endTime);
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
        if (parts.length < 3) {
            throw new Exception(this.error.getMessage("missing datetime description"));
        }
    }

    /**
     * Verifies if the date/time description has enough parts.
     *
     * @param dateTimeParts the split date/time description.
     * @throws Exception if the description is incomplete.
     */
    private void verifyDateTimeDescription(String[] dateTimeParts) throws Exception {
        if (dateTimeParts.length < 3) {
            throw new Exception(this.error.getMessage("missing datetime description"));
        }
    }

    /**
     * Verifies if the date/time code is valid.
     *
     * @param start the code of start date/time string.
     * @param end the code of end date/time string.
     * @throws Exception if the code is invalid.
     */
    private void verifyDateTimeCode(String start, String end) throws Exception {
        if (!start.equals("from") || !end.equals("to")) {
            throw new Exception(this.error.getMessage("invalid event datetime code"));
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
