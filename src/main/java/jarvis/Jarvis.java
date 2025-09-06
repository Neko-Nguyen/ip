package jarvis;

import javafx.application.Application;
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
     * Returns a greeting message for when the application starts.
     *
     * @return greeting message.
     */
    public String greet() {
        return ui.getGreeting();
    }

    /**
     * Returns a response from the chatbot with the given input.
     *
     * @param input the input from the user.
     * @return the response to the user.
     */
    public String getResponse(String input) {
        String response = parser.parse(new Task(input));

        storage.update(list);
        storage.save();

        return response;
    }

    /**
     * Displays greeting and processes user commands until exit.
     * Saves task after each command execution.
     */
    public void run() {
        System.out.print(ui.getGreeting());
        while (true) {
            String input = scanner.nextLine();

            ui.printSectionLine();

            String response = parser.parse(new Task(input));
            if (response.charAt(0) == '!') {
                break;
            }

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
