package jarvis;

import jarvis.command.ByeCommand;
import jarvis.command.DeadlineCommand;
import jarvis.command.DeleteCommand;
import jarvis.command.EventCommand;
import jarvis.command.FindCommand;
import jarvis.command.ListCommand;
import jarvis.command.MarkCommand;
import jarvis.command.TodoCommand;
import jarvis.command.UnmarkCommand;

/**
 * Handles user interface operations, manages display output, command
 *  execution, and user interaction.
 *
 * @author Neko-Nguyen
 */
public class Ui {
    private TaskList list;

    public Ui(TaskList list) {
        this.list = list;
    }

    /**
     * Prints a section divider line for better output formatting.
     */
    public void printSectionLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Returns a presentation for readme file.
     *
     * @return presentation.
     */
    public String getPresentation() {
        String presentation = "";
        presentation += "╔══════════════════════════════════════════════════╗\n";
        presentation += "║  *JUST A RATHER VERY INTELLIGENT SYSTEM*         ║\n";
        presentation += "║  ------------------------------------------      ║\n";
        presentation += "║                                                  ║\n";
        presentation += "║  >> System Boot: .......... Complete             ║\n";
        presentation += "║  >> Diagnostics: .......... Optimal              ║\n";
        presentation += "║  >> Network Status: ....... Secure               ║\n";
        presentation += "║  >> Power: ................. 400% Capacity       ║\n";
        presentation += "║                                                  ║\n";
        presentation += "║  Good evening, Sir. How may I be of service?     ║\n";
        presentation += "╚══════════════════════════════════════════════════╝\n";
        return presentation;
    }

    /**
     * Returns a greeting message when the chatbot starts.
     *
     * @return greeting message.
     */
    public String getGreeting() {
        String greeting = "";
        greeting += "---------------------------------\n";
        greeting += "   J.A.R.V.I.S. Initializing...\n";
        greeting += "---------------------------------\n";
        greeting += "Good evening, Sir. Systems are now online.\n";
        greeting += "All protocols operational. Awaiting your command.\n";
        return greeting;
    }

    /**
     * Executes the bye command to exit the chatbot.
     */
    public String replyByeCommand() {
        return new ByeCommand().execute();
    }

    /**
     * Executes the list command to display all the tasks in the list.
     */
    public String replyListCommand() {
        return new ListCommand(list).execute();
    }

    /**
     * Executes the mark command to mark the task of the given index as done.
     *
     * @param index the string of the index of the task to be marked.
     */
    public String replyMarkCommand(String index) {
        return new MarkCommand(list, index).execute();
    }

    /**
     * Executes the unmark command to mark the task of the given index as not done.
     *
     * @param index the string of the index of the task to be unmarked.
     */
    public String replyUnmarkCommand(String index) {
        return new UnmarkCommand(list, index).execute();
    }

    /**
     * Executes the t-odo command to add a t-odo task into the list.
     *
     * @param task the description string of the t-odo task to be added to the list.
     */
    public String replyTodoCommand(String task) {
        return new TodoCommand(list, task).execute();
    }

    /**
     * Executes the deadline command to add a deadline task into the list.
     *
     * @param task the description string of the deadline task to be added to the list.
     */
    public String replyDeadlineCommand(String task) {
        return new DeadlineCommand(list, task).execute();
    }

    /**
     * Executes the event command to add an event task into the list.
     *
     * @param task the description string of the event task to be added to the list.
     */
    public String replyEventCommand(String task) {
        return new EventCommand(list, task).execute();
    }

    /**
     * Executes the delete command to delete the specified task.
     *
     * @param index the string of the index of the task to be deleted from the list.
     */
    public String replyDeleteCommand(String index) {
        return new DeleteCommand(list, index).execute();
    }

    /**
     * Executes the find command to search for all the tasks with the matching keyword.
     *
     * @param keyword the keyword to be used to search for the matching tasks.
     */
    public String replyFindCommand(String keyword) {
        return new FindCommand(list, keyword).execute();
    }

    /**
     * Returns the message shown when the list description is missing.
     *
     * @return missing task description message.
     */
    public String getMissingDescriptionMessage() {
        return "Sir, the mission parameters are incomplete.\n"
                + "A task description is required to proceed.\n";
    }

    /**
     * Returns the message shown when the input command is unrecognizable.
     *
     * @return unrecognizable command message.
     */
    public String getUnrecognizableCommandMessage() {
        return "Sir, that command syntax is unrecognized.\n"
                + "Please rephrase your directive.\n";
    }
}
