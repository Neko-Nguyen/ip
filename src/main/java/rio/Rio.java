package rio;

import rio.task.Task;
import java.util.Scanner;

/**
 * Main class for the Rio chatbot - a simple personal assistant
 * that helps users to manage their tasks.
 *
 * @author Neko-Nguyen
 */
public class Rio {
    private Scanner scanner;
    private Storage storage;
    private TaskList list;
    private Ui ui;
    private Parser parser;

    public Rio() {
        scanner = new Scanner(System.in);
        storage = new Storage();

        storage.load();
        list = storage.getList();

        ui = new Ui(list);
        parser = new Parser(ui);
    }

    /**
     * Displays greeting and processes user commands until exit.
     * Saves task after each command execution.
     */
    public void run() {
        ui.printGreeting();
        while (parser.parse(new Task(scanner.nextLine()))) {
            storage.update(list);
            storage.save();

            ui.printSectionLine();
        }
        ui.printSectionLine();
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        new Rio().run();
    }
}
