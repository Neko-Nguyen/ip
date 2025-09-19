package jarvis.ui;

import jarvis.command.ByeCommand;
import jarvis.command.DeadlineCommand;
import jarvis.command.DeleteCommand;
import jarvis.command.EventCommand;
import jarvis.command.FindCommand;
import jarvis.command.ListCommand;
import jarvis.command.MarkCommand;
import jarvis.command.TagCommand;
import jarvis.command.TodoCommand;
import jarvis.command.UnmarkCommand;
import jarvis.command.UntagCommand;
import jarvis.task.TaskList;

/**
 * Handles user interface operations, manages display output, command
 *  execution, and user interaction.
 *
 * @author Neko-Nguyen
 */
public class Ui {
    /** Presentation to Jarvis, your personal assistance. */
    private static final String PRESENTATION = """
            \
            ╔══════════════════════════════════════════════════╗
            ║  *JUST A RATHER VERY INTELLIGENT SYSTEM*         ║
            ║  ------------------------------------------      ║
            ║                                                  ║
            ║  >> System Boot: .......... Complete             ║
            ║  >> Diagnostics: .......... Optimal              ║
            ║  >> Network Status: ....... Secure               ║
            ║  >> Power: ................. 400% Capacity       ║
            ║                                                  ║
            ║  Good evening, Sir. How may I be of service?     ║
            ╚══════════════════════════════════════════════════╝
            """;
    /** Section divider line. */
    private static final String SECTION_LINE =
            "____________________________________________________________";
    /** Start up greeting. */
    private static final String GREETING = """
            \
            ---------------------------------
               J.A.R.V.I.S. Initializing...
            ---------------------------------
            Good evening, Sir. Systems are now online.
            All protocols operational. Awaiting your command.
            """;
    /** List of tasks. */
    private final TaskList list;

    public Ui(TaskList list) {
        this.list = list;
    }

    /**
     * Prints a section divider line for better output formatting.
     */
    public void printSectionLine() {
        System.out.println(SECTION_LINE);
    }

    /**
     * Returns a presentation for readme file.
     *
     * @return presentation.
     */
    public String getPresentation() {
        return PRESENTATION;
    }

    /**
     * Returns a greeting message when the chatbot starts.
     *
     * @return greeting message.
     */
    public String getGreeting() {
        return GREETING;
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
        return new ListCommand(this.list).execute();
    }

    /**
     * Executes the mark command to mark the task of the given index as done.
     *
     * @param index the string of the index of the task to be marked.
     */
    public String replyMarkCommand(String index) {
        return new MarkCommand(this.list, index).execute();
    }

    /**
     * Executes the unmark command to mark the task of the given index as not done.
     *
     * @param index the string of the index of the task to be unmarked.
     */
    public String replyUnmarkCommand(String index) {
        return new UnmarkCommand(this.list, index).execute();
    }

    /**
     * Executes the t-odo command to add a t-odo task into the list.
     *
     * @param task the description string of the t-odo task to be added to the list.
     */
    public String replyTodoCommand(String task) {
        return new TodoCommand(this.list, task).execute();
    }

    /**
     * Executes the deadline command to add a deadline task into the list.
     *
     * @param task the description string of the deadline task to be added to the list.
     */
    public String replyDeadlineCommand(String task) {
        return new DeadlineCommand(this.list, task).execute();
    }

    /**
     * Executes the event command to add an event task into the list.
     *
     * @param task the description string of the event task to be added to the list.
     */
    public String replyEventCommand(String task) {
        return new EventCommand(this.list, task).execute();
    }

    /**
     * Executes the delete command to delete the specified task.
     *
     * @param index the string of the index of the task to be deleted from the list.
     */
    public String replyDeleteCommand(String index) {
        return new DeleteCommand(this.list, index).execute();
    }

    /**
     * Executes the find command to search for all the tasks with the matching keyword.
     *
     * @param keyword the keyword to be used to search for the matching tasks.
     */
    public String replyFindCommand(String keyword) {
        return new FindCommand(this.list, keyword).execute();
    }

    /**
     * Executes the tag command to add a tag to the specified task.
     *
     * @param description the description string of the task index and the tag name to be added.
     */
    public String replyTagCommand(String description) {
        return new TagCommand(this.list, description).execute();
    }

    /**
     * Executes the untag command to remove a tag from the specified task.
     *
     * @param description the description string of the task index and the tag index to be removed.
     */
    public String replyUntagCommand(String description) {
        return new UntagCommand(this.list, description).execute();
    }
}
