package jarvis;

import java.util.Scanner;

import jarvis.task.Task;

/**
 * Main class for the Jarvis chatbot - a simple personal assistant
 * that helps users to manage their tasks.
 *
 * @author Neko-Nguyen
 */
public class Jarvis {
    private Scanner scanner;
    private Storage storage;
    private TaskList list;
    private Ui ui;
    private Parser parser;

    /**
     * Constructs a Jarvis chatbot instance.
     * Initializes all components including scanner, storage, task list, UI, and parser.
     * Loads existing tasks from storage upon initialization.
     */
    public Jarvis() {
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
        new Jarvis().run();
    }
}
