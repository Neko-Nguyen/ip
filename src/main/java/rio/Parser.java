package rio;

import rio.task.Task;

enum Command {
    bye, list, mark, unmark, todo, deadline, event, delete, find
}

/**
 * Parses the message of the task and detects the type of command the user
 *  use.
 *
 * @author Neko-Nguyen
 */
public class Parser {
    private Ui ui;

    public Parser(Ui ui) {
        this.ui = ui;
    }

    /**
     * Reads the message of the task and detects the type of command the
     *  user use and checks if the command is the bye command or not.
     *
     * @param task the task with the raw input of the user.
     * @return {@code true} when the command type is bye, {@code false} if otherwise.
     */
    public boolean parse(Task task) {
        ui.printSectionLine();
        String[] command = task.get().split(" ", 2);
        try {
            Command cmd = Command.valueOf(command[0]);
            if (cmd == Command.bye) {
                ui.runByeCommand();
                return false;
            }

            if (cmd == Command.list) {
                ui.runListCommand();
            } else if (ui.isEnoughDescription(command.length)) {
                return true;
            }

            if (cmd == Command.mark) {
                ui.runMarkCommand(command[1]);
            } else if (cmd == Command.unmark) {
                ui.runUnmarkCommand(command[1]);
            } else if (cmd == Command.todo) {
                ui.runTodoCommand(command[1]);
            } else if (cmd == Command.deadline) {
                ui.runDeadlineCommand(command[1]);
            } else if (cmd == Command.event) {
                ui.runEventCommand(command[1]);
            } else if (cmd == Command.delete) {
                ui.runDeleteCommand(command[1]);
            } else if (cmd == Command.find) {
                ui.runFindCommand(command[1]);
            }
        } catch (IllegalArgumentException e) {
            ui.printUnrecognizableCommandError();
        }
        return true;
    }
}
