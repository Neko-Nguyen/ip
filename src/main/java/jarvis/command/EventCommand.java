package jarvis.command;

import java.time.format.DateTimeParseException;

import jarvis.DateConverter;
import jarvis.TaskList;
import jarvis.TimeConverter;
import jarvis.task.Event;
import jarvis.task.Task;

/**
 * Represents a command that creates an event task and adds it
 * to the list.
 *
 * @author Neko-Nguyen
 */
public class EventCommand {
    private TaskList list;
    private String task;

    /**
     * Creates a EventCommand to add a event task.
     *
     * @param list TaskList to add the task to
     * @param task Event task description (format: "task /from start /to end ")
     */
    public EventCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
    }

    /**
     * Executes the command by parsing the start and end date/time, creating
     *  a new event task and adding it to the list.
     *
     * @return the response to the user.
     */
    public String execute() {
        String[] parts = task.split("/");
        String[] start = parts[1].split(" ");
        String[] end = parts[2].split(" ");

        try {
            assert parts.length > 1 : getMissingDateTimeMessage();
            assert start.length > 1 : getMissingDateTimeMessage();
            assert end.length > 1 : getMissingDateTimeMessage();
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
            return getWrongFormatMessage();
        }

        Task newTask = new Event(parts[0], startDate + ", " + startTime,
                                        endDate + ", " + endTime);
        list.add(newTask);

        String response = "";

        response += "Protocol initiated. Task archived:\n";
        response += "   " + newTask + "\n";
        response += "Sir, the list now contains " + list.getSize() + " active mission"
                + (list.getSize() == 1 ? "" : "s") + ".\n";

        return response;
    }

    /**
     * Returns the message shown when the date and time is in the wrong format.
     *
     * @return wrong format message.
     */
    public String getWrongFormatMessage() {
        return "Sir, I'm afraid that temporal input doesn't compute.\n"
                + "Please format your date and time as yyyy-MM-dd HHmm\n"
                + "(e.g., 2019-10-15 1800). Protocol requires precision.\n";
    }

    /**
     * Returns the message shown when the date or the time is missing.
     *
     * @return missing date or time message.
     */
    public String getMissingDateTimeMessage() {
        return "Sir, the temporal coordinates for this event are missing.\n"
                + " A start and end time are required to proceed.\n";
    }
}
