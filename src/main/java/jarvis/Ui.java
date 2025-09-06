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
        System.out.println("   ____________________________________________________________");
    }

    /**
     * Displays the logo and welcome presentation.
     */
    public void printPresentation() {
        String logo = " ____  _       \n"
                + "|  _ \\(_) ___  \n"
                + "| |_) | |/ _ \\ \n"
                + "|  _ <| | |_| |\n"
                + "|_| \\_\\_|\\___/ \n";

        System.out.println("Hello from\n" + logo);
    }

    /**
     * Displays a greeting message when the chatbot starts.
     */
    public void printGreeting() {
        printSectionLine();
        System.out.println("    Hello, I'm Jarvis - your personal assistant.");
        System.out.println("    What can I do for you today?");
        printSectionLine();
    }

    /**
     * Executes the bye command to exit the chatbot.
     */
    public void runByeCommand() {
        new ByeCommand().execute();
    }

    /**
     * Executes the list command to display all the tasks in the list.
     */
    public void runListCommand() {
        new ListCommand(list).execute();
    }

    /**
     * Executes the mark command to mark the task of the given index as done.
     *
     * @param index the string of the index of the task to be marked.
     */
    public void runMarkCommand(String index) {
        new MarkCommand(list, index).execute();
    }

    /**
     * Executes the unmark command to mark the task of the given index as not done.
     *
     * @param index the string of the index of the task to be unmarked.
     */
    public void runUnmarkCommand(String index) {
        new UnmarkCommand(list, index).execute();
    }

    /**
     * Executes the t-odo command to add a t-odo task into the list.
     *
     * @param task the description string of the t-odo task to be added to the list.
     */
    public void runTodoCommand(String task) {
        new TodoCommand(list, task).execute();
    }

    /**
     * Executes the deadline command to add a deadline task into the list.
     *
     * @param task the description string of the deadline task to be added to the list.
     */
    public void runDeadlineCommand(String task) {
        new DeadlineCommand(list, task).execute();
    }

    /**
     * Executes the event command to add an event task into the list.
     *
     * @param task the description string of the event task to be added to the list.
     */
    public void runEventCommand(String task) {
        new EventCommand(list, task).execute();
    }

    /**
     * Executes the delete command to delete the specified task.
     *
     * @param index the string of the index of the task to be deleted from the list.
     */
    public void runDeleteCommand(String index) {
        new DeleteCommand(list, index).execute();
    }

    /**
     * Executes the find command to search for all the tasks with the matching keyword.
     *
     * @param keyword the keyword to be used to search for the matching tasks.
     */
    public void runFindCommand(String keyword) {
        new FindCommand(list, keyword).execute();
    }

    /**
     * Checks if the command has enough description and prints the message to inform
     *  the user of the error in the command line.
     *
     * @param numOfWords the number of words in the command line.
     * @return {@code true} when there is only one word in the command, {@code false} if otherwise.
     */
    public boolean isEnoughDescription(int numOfWords) {
        if (numOfWords == 1) {
            System.out.println("    Oops! You should add some description to your task.");
            return true;
        }
        return false;
    }

    /**
     * Prints the message to inform the user that the chatbot does not recognize the
     *  command.
     */
    public void printUnrecognizableCommandError() {
        System.out.println("    Oops! Sorry but I don't understand. :/");
    }
}
