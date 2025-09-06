package rio.command;

import java.time.format.DateTimeParseException;

import rio.DateConverter;
import rio.TaskList;
import rio.TimeConverter;
import rio.task.Deadline;
import rio.task.Task;

/**
 * Represents a command that creates a deadline task and add it to the
 * list.
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
     */
    public void execute() {
        try {
            String[] parts = task.split("/");
            if (isMissingDateTime(parts.length)) {
                return;
            }

            String[] deadline = parts[1].split(" ");
            if (isMissingDateTime(deadline.length)) {
                return;
            }

            String deadlineDate = deadline.length >= 2 ? new DateConverter(deadline[1]).convert() : "";
            String deadlineTime = deadline.length == 3 ? new TimeConverter(deadline[2]).convert() : "";

            Task newTask = new Deadline(parts[0], deadlineDate + ", " + deadlineTime);

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
