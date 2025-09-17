package jarvis;

import jarvis.task.Task;

enum Command {
    bye, list, mark, unmark, todo, deadline, event, delete, find, tag
}

/**
 * Parses the message of the task and detects the type of command the user
 *  use.
 *
 * @author Neko-Nguyen
 */
public class Parser {
    /** Handles the user interface interactions. */
    private final Ui ui;
    /** Error message dictionary. */
    private final ErrorMessage error;

    public Parser(Ui ui) {
        this.ui = ui;
        this.error = new ErrorMessage();
    }

    /**
     * Parses the task description to identify and execute the corresponding
     *  command.
     *
     * @param task the task containing the user's input.
     * @return the response to the user.
     */
    public String parse(Task task) {
        String[] command = task.getDescription().split(" ", 2);
        try {
            Command cmd = parseCommand(command[0]);
            return executeSimpleCommand(cmd, command);
        } catch (IllegalArgumentException e) {
            return this.error.getMessage("unrecognizable command");
        }
    }

    /**
     * Parses the command string to its corresponding Command enum.
     *
     * @param command the command string to be parsed.
     * @return the corresponding Command enum.
     */
    private Command parseCommand(String command) {
        return Command.valueOf(command);
    }

    /**
     * Executes commands that do not require additional arguments.
     *
     * @param cmd the command to be executed.
     * @param command the full command array.
     * @return the response to the user.
     */
    private String executeSimpleCommand(Command cmd, String[] command) {
        return switch (cmd) {
            case bye -> this.ui.replyByeCommand();
            case list -> this.ui.replyListCommand();
            default -> executeComplexCommand(cmd, command);
        };
    }

    /**
     * Executes commands that require additional arguments.
     *
     * @param cmd the command to be executed.
     * @param command the full command array.
     * @return the response to the user.
     */
    private String executeComplexCommand(Command cmd, String[] command) {
        try {
            assert command.length > 1 : this.error.getMessage("missing task description");
            String description = command[1];

            return switch (cmd) {
                case mark -> this.ui.replyMarkCommand(description);
                case unmark -> this.ui.replyUnmarkCommand(description);
                case todo -> this.ui.replyTodoCommand(description);
                case deadline -> this.ui.replyDeadlineCommand(description);
                case event -> this.ui.replyEventCommand(description);
                case delete -> this.ui.replyDeleteCommand(description);
                case find -> this.ui.replyFindCommand(description);
                case tag -> this.ui.replyTagCommand(description);
                default -> this.error.getMessage("unrecognizable command");
            };
        } catch (AssertionError e) {
            return e.getMessage();
        }
    }
}
