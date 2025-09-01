package rio;

import rio.command.ByeCommand;
import rio.command.ListCommand;
import rio.command.MarkCommand;
import rio.command.UnmarkCommand;
import rio.command.TodoCommand;
import rio.command.DeadlineCommand;
import rio.command.EventCommand;
import rio.command.DeleteCommand;

public class Ui {
    private TaskList list;

    public Ui(TaskList list) {
        this.list = list;
    }

    public void printSectionLine() {
        System.out.println("   ____________________________________________________________");
    }

    public void printPresentation() {
        String logo = " ____  _       \n"
                + "|  _ \\(_) ___  \n"
                + "| |_) | |/ _ \\ \n"
                + "|  _ <| | |_| |\n"
                + "|_| \\_\\_|\\___/ \n";

        System.out.println("Hello from\n" + logo);
    }

    public void printGreeting() {
        printSectionLine();
        System.out.println("    Hello, I'm rio.Rio - your personal assistant.");
        System.out.println("    What can I do for you today?");
        printSectionLine();
    }

    public void runByeCommand() {
        new ByeCommand().process();
    }

    public void runListCommand() {
        new ListCommand(list).process();
    }

    public void runMarkCommand(String index) {
        new MarkCommand(list, index).process();
    }

    public void runUnmarkCommand(String index) {
        new UnmarkCommand(list, index).process();
    }

    public void runTodoCommand(String task) {
        new TodoCommand(list, task).process();
    }

    public void runDeadlineCommand(String task) {
        new DeadlineCommand(list, task).process();
    }

    public void runEventCommand(String task) {
        new EventCommand(list, task).process();
    }

    public void runDeleteCommand(String index) {
        new DeleteCommand(list, index).process();
    }

    public boolean isEnoughDescription(int numOfWords) {
        if (numOfWords == 1) {
            System.out.println("    Oops! You should add some description to your task.");
            return true;
        }
        return false;
    }

    public void printUnrecognizableCommandError() {
        System.out.println("    Oops! Sorry but I don't understand. :/");
    }
}
