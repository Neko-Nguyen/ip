package jarvis.command;

import java.time.format.DateTimeParseException;

import jarvis.converter.DateConverter;
import jarvis.ErrorMessage;
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
    private TaskList list;
    /** Event task. */
    private String task;
    /** Error message dictionary. */
    private ErrorMessage error;

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
        String[] parts = this.task.split("/");
        String[] start = parts[1].split(" ");
        String[] end = parts[2].split(" ");

        try {
            assert parts.length > 1 : this.error.getMessage("missing datetime description");
            assert start.length > 1 : this.error.getMessage("missing datetime description");
            assert end.length > 1 : this.error.getMessage("missing datetime description");
        } catch (AssertionError e) {
            return e.getMessage();
        }

        String startDate = "";
        String startTime = "";
        String endDate = "";
        String endTime = "";

        try {
            startDate = start.length >= 2 ? new DateConverter(start[1]).convert() : "";
            startTime = start.length == 3 ? new TimeConverter(start[2]).convert() : "";

            endDate = end.length >= 2 ? new DateConverter(end[1]).convert() : "";
            endTime = end.length == 3 ? new TimeConverter(end[2]).convert() : "";

        } catch (DateTimeParseException e) {
            return this.error.getMessage("invalid datetime format");
        }

        Task newTask = new Event(parts[0], startDate + ", " + startTime,
                                        endDate + ", " + endTime);
        this.list.add(newTask);

        String response = "";

        response += "Protocol initiated. Task archived:\n";
        response += "   " + newTask;
        response += "Sir, the list now doesContain " + this.list.getSize() + " active mission"
                + (this.list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }
}
