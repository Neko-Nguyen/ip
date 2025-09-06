package rio.command;

import java.time.format.DateTimeParseException;

import rio.DateConverter;
import rio.TaskList;
import rio.TimeConverter;
import rio.task.Event;
import rio.task.Task;

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
     */
    public void execute() {
        try {
            String[] parts = task.split("/");
            if (isMissingDateTime(parts.length)) {
                return;
            }

            String[] start = parts[1].split(" ");
            String[] end = parts[2].split(" ");
            if (isMissingDateTime(start.length)) {
                return;
            }
            if (isMissingDateTime(end.length)) {
                return;
            }

            String startDate = start.length >= 2 ? new DateConverter(start[1]).convert() : "";
            String startTime = start.length == 3 ? new TimeConverter(start[2]).convert() : "";

            String endDate = end.length >= 2 ? new DateConverter(end[1]).convert() : "";
            String endTime = end.length == 3 ? new TimeConverter(end[2]).convert() : "";

            Task newTask = new Event(parts[0], startDate + ", " + startTime,
                                            endDate + ", " + endTime);
            list.add(newTask);
            System.out.println("    Added: " + newTask);
            System.out.println("    Now you have " + list.getSize() + " task"
                    + (list.getSize() == 1 ? "" : "s") + " in your list.");
        } catch (DateTimeParseException e) {
            printWrongFormatError();
        }
    }

    /**
     * Prints an error message indicating the expected date/time format.
     */
    public void printWrongFormatError() {
        System.out.println("    Oops! Sorry but your date and time "
                + "should be in the yyyy-MM-dd HHmm format. (like 2019-10-15 1800)");
    }

    /**
     * Checks if the command is long enough and if it is missing the date/time.
     *
     * @param commandLength the length of the command.
     * @return {@code true} when the command is missing the date/time, {@code false} if otherwise.
     */
    public boolean isMissingDateTime(int commandLength) {
        if (commandLength == 1) {
            System.out.println("    Oops! You should add a deadline date and time to your task.");
            return true;
        }
        return false;
    }
}
