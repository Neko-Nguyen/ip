package rio;

import rio.task.Task;

enum Command {
    bye, list, mark, unmark, todo, deadline, event, delete
}

/**
 * Parses the message of the task and detects the type of command the user
 * use.
 * @author Neko-Nguyen
 */
public class Parser {
    private Ui ui;

    public Parser(Ui ui) {
        this.ui = ui;
    }

    /**
     * Reads the message of the task and detects the type of command the
     * user use and checks if the command is the bye command or not.
     * @param task the task with the raw input of the user.
     * @return {@code true} when the command type is bye, {@code false}
     * if otherwise.
     */
    public boolean read(Task task) {
        ui.printSectionLine();
        String[] command = task.get().split(" ", 2);
        try {
            Command cmd = Command.valueOf(command[0]);
            if (cmd == Command.bye) {
                ui.byeCommand();
                return false;
            }
            if (cmd == Command.list) ui.listCommand();
            else if (ui.isEnoughDescription(command.length)) return true;
            if (cmd == Command.mark) ui.markCommand(command[1]);
            if (cmd == Command.unmark) ui.unmarkCommand(command[1]);
            if (cmd == Command.todo) ui.todoCommand(command[1]);
            if (cmd == Command.deadline) ui.deadlineCommand(command[1]);
            if (cmd == Command.event) ui.eventCommand(command[1]);
            if (cmd == Command.delete) ui.deleteCommand(command[1]);
        } catch (IllegalArgumentException e) {
            ui.notRecognizeCommand();
        }
        return true;
    }
}
