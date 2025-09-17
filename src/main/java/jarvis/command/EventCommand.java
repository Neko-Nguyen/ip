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
            if (parts.length < 3) {
                throw new Exception(this.error.getMessage("missing datetime description"));
            }

            String[] start = parts[1].split(" ");
            String[] end = parts[2].split(" ");
            if (start.length < 3 || end.length < 3) {
                throw new Exception(this.error.getMessage("missing datetime description"));
            }
            if (!start[0].equals("from") || !end[0].equals("to")) {
                throw new Exception(this.error.getMessage("invalid event datetime format"));
            }

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
