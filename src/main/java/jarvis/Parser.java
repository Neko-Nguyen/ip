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
    /** Handles the user interface interactions. */
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
                response = this.ui.replyByeCommand();
            } else if (cmd == Command.list) {
                response = this.ui.replyListCommand();
            } else if (command.length == 1) {
                response = this.ui.getMissingDescriptionMessage();
            } else if (cmd == Command.mark) {
                response = this.ui.replyMarkCommand(command[1]);
            } else if (cmd == Command.unmark) {
                response = this.ui.replyUnmarkCommand(command[1]);
            } else if (cmd == Command.todo) {
                response = this.ui.replyTodoCommand(command[1]);
            } else if (cmd == Command.deadline) {
                response = this.ui.replyDeadlineCommand(command[1]);
            } else if (cmd == Command.event) {
                response = this.ui.replyEventCommand(command[1]);
            } else if (cmd == Command.delete) {
                response = this.ui.replyDeleteCommand(command[1]);
            } else if (cmd == Command.find) {
                response = this.ui.replyFindCommand(command[1]);
            }
        } catch (IllegalArgumentException e) {
            response = this.ui.getUnrecognizableCommandMessage();
        }

        System.out.print(response);
        return response;
    }
}
