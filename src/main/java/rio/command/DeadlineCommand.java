package rio.command;

import rio.DateConverter;
import rio.TimeConverter;
import rio.TaskList;
import rio.task.Deadline;
import rio.task.Task;

import java.time.format.DateTimeParseException;

public class DeadlineCommand {
    private TaskList list;
    private String task;

    public DeadlineCommand(TaskList list, String task) {
        this.list = list;
        this.task = task;
    }

    public void process() {
        try {
            String[] parts = task.split("/");
            if (isMissingDateTime(parts.length)) return;

            String[] deadline = parts[1].split(" ");
            if (isMissingDateTime(deadline.length)) return;

            System.out.println(deadline[1]);
            String deadlineDate = deadline.length >= 2 ? new DateConverter(deadline[1]).convert() : "";
            String deadlineTime = deadline.length == 3 ? new TimeConverter(deadline[2]).convert() : "";

            Task newTask = new Deadline(parts[0], deadlineDate + ", " + deadlineTime);

            list.add(newTask);
            System.out.println("    Added: " + newTask);
            System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
        } catch (DateTimeParseException e) {
            wrongDateTimeFormat();
        }
    }

    public void wrongDateTimeFormat() {
        System.out.println("    Oops! Sorry but your date and time should be in the yyyy-MM-dd HHmm format. (like 2019-10-15 1800)");
    }

    public boolean isMissingDateTime(int commandLength) {
        if (commandLength == 1) {
            System.out.println("    Oops! You should add a deadline date and time to your task.");
            return true;
        }
        return false;
    }
}
