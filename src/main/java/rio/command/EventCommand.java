package rio.command;

import rio.DateConverter;
import rio.TaskList;
import rio.TimeConverter;
import rio.task.Event;
import rio.task.Task;

import java.time.format.DateTimeParseException;

public class EventCommand {
    private TaskList list;
    private String task;

    public EventCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
    }

    public void process() {
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

            Task newTask = new Event(parts[0], startDate + ", " + startTime
                                            , endDate + ", " + endTime);
            list.add(newTask);
            System.out.println("    Added: " + newTask);
            System.out.println("    Now you have " + list.getSize() + " task"
                    + (list.getSize() == 1 ? "" : "s") + " in your list.");
        } catch (DateTimeParseException e) {
            printWrongFormatError();
        }
    }

    public void printWrongFormatError() {
        System.out.println("    Oops! Sorry but your date and time " +
                "should be in the yyyy-MM-dd HHmm format. (like 2019-10-15 1800)");
    }

    public boolean isMissingDateTime(int commandLength) {
        if (commandLength == 1) {
            System.out.println("    Oops! You should add a deadline date and time to your task.");
            return true;
        }
        return false;
    }
}
