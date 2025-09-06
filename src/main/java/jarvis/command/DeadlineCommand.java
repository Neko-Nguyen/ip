package jarvis.command;

import java.time.format.DateTimeParseException;

import jarvis.DateConverter;
import jarvis.TaskList;
import jarvis.TimeConverter;
import jarvis.task.Deadline;
import jarvis.task.Task;

/**
 * Represents a command that creates a deadline task and add it to the
 *  list.
 *
 * @author Neko-Nguyen
 */
public class DeadlineCommand {
    private TaskList list;
    private String task;

    /**
     * Creates a DeadlineCommand to add a deadline task.
     *
     * @param list TaskList to add the task to.
     * @param task Deadline task description (format: "task /by deadline").
     */
    public DeadlineCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
    }

    /**
     * Executes the command by parsing the deadline date/time, creating a
     *  new deadline task and adding it to the list.
     *
     * @return the response to the user.
     */
    public String execute() {
        String[] parts = task.split("/");
        if (parts.length == 1) {
            return getMissingDateTimeMessage();
        }

        String[] deadline = parts[1].split(" ");
        if (deadline.length == 1) {
            return getMissingDateTimeMessage();
        }

        String deadlineDate = "";
        String deadlineTime = "";

        try {
            deadlineDate = deadline.length >= 2 ? new DateConverter(deadline[1]).convert() : "";
            deadlineTime = deadline.length == 3 ? new TimeConverter(deadline[2]).convert() : "";
        } catch (DateTimeParseException e) {
            return getWrongFormatMessage();
        }

        Task newTask = new Deadline(parts[0], deadlineDate + ", " + deadlineTime);
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
        return "Sir, my temporal sensors are detecting an incomplete coordinate.\n"
                + "A deadline requires both a date and time to be properly logged.\n"
                + "Please provide the full specification.\n";
    }
}
