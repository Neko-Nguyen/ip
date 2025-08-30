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

    public void presentation() {
        String logo = " ____  _       \n"
                + "|  _ \\(_) ___  \n"
                + "| |_) | |/ _ \\ \n"
                + "|  _ <| | |_| |\n"
                + "|_| \\_\\_|\\___/ \n";

        System.out.println("Hello from\n" + logo);
    }

    public void greeting() {
        printSectionLine();
        System.out.println("    Hello, I'm rio.Rio - your personal assistant.");
        System.out.println("    What can I do for you today?");
        printSectionLine();
    }

    public void byeCommand() { new ByeCommand().process(); }

    public void listCommand() { new ListCommand(list).process(); }

    public void markCommand(String index) { new MarkCommand(list, index).process(); }

    public void unmarkCommand(String index) { new UnmarkCommand(list, index).process(); }

    public void todoCommand(String task) { new TodoCommand(list, task).process(); }

    public void deadlineCommand(String task) { new DeadlineCommand(list, task).process(); }

    public void eventCommand(String task) { new EventCommand(list, task).process(); }

    public void deleteCommand(String index) { new DeleteCommand(list, index).process(); }

    public boolean isEnoughDescription(int numOfWords) {
        if (numOfWords == 1) {
            System.out.println("    Oops! You should add some description to your task.");
            return true;
        }
        return false;
    }

    public void notRecognizeCommand() {
        System.out.println("    Oops! Sorry but I don't understand. :/");
    }
}
