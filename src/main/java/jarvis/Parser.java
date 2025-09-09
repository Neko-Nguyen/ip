package jarvis;

import jarvis.task.Task;

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
     *  user use and returns a response.
     *
     * @param task the task with the raw input of the user.
     * @return the response to the user.
     */
    public String parse(Task task) {
        String[] command = task.get().split(" ", 2);
        String response = " ";

        try {
            Command cmd = Command.valueOf(command[0]);

            if (cmd == Command.bye) {
                response = ui.replyByeCommand();
            } else if (cmd == Command.list) {
                response = ui.replyListCommand();
            } else {
                try {
                    assert command.length > 1 : ui.getMissingDescriptionMessage();

                    if (cmd == Command.mark) {
                        response = ui.replyMarkCommand(command[1]);
                    } else if (cmd == Command.unmark) {
                        response = ui.replyUnmarkCommand(command[1]);
                    } else if (cmd == Command.todo) {
                        response = ui.replyTodoCommand(command[1]);
                    } else if (cmd == Command.deadline) {
                        response = ui.replyDeadlineCommand(command[1]);
                    } else if (cmd == Command.event) {
                        response = ui.replyEventCommand(command[1]);
                    } else if (cmd == Command.delete) {
                        response = ui.replyDeleteCommand(command[1]);
                    } else if (cmd == Command.find) {
                        response = ui.replyFindCommand(command[1]);
                    }
                } catch (AssertionError e) {
                    response = e.getMessage();
                }
            }
        } catch (IllegalArgumentException e) {
            response = ui.getUnrecognizableCommandMessage();
        }

        System.out.print(response);
        return response;
    }
}
