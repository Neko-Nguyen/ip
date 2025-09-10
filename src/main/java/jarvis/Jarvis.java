package jarvis;

import java.util.Scanner;

import jarvis.task.Task;
import jarvis.task.TaskList;

/**
 * Main class for the Jarvis chatbot - a simple personal assistant
 * that helps users to manage their tasks.
 *
 * @author Neko-Nguyen
 */
public class Jarvis {
    /** Scanner for reading the inputs from the user. */
    private Scanner scanner;
    /** Handles saving and loading tasks from persistent storage. */
    private Storage storage;
    /** List of tasks. */
    private TaskList list;
    /** Handles the user interface interactions. */
    private Ui ui;
    /** Parses the user input and executes the corresponding commands. */
    private Parser parser;

    /**
     * Constructs a Jarvis chatbot instance.
     * Initializes all components including scanner, storage, task list, UI, and parser.
     * Loads existing tasks from storage upon initialization.
     */
    public Jarvis() {
        this.scanner = new Scanner(System.in);
        this.storage = new Storage();

        this.storage.load();
        this.list = this.storage.getList();

        this.ui = new Ui(this.list);
        this.parser = new Parser(this.ui);
    }

    /**
     * Returns a greeting message for when the application starts.
     *
     * @return greeting message.
     */
    public String greet() {
        return this.ui.getGreeting();
    }

    /**
     * Returns a response from the chatbot with the given input.
     *
     * @param input the input from the user.
     * @return the response to the user.
     */
    public String getResponse(String input) {
        String response = this.parser.parse(new Task(input));

        this.storage.update(this.list);
        this.storage.save();

        return response;
    }

    /**
     * Displays greeting and processes user commands until exit.
     * Saves task after each command execution.
     */
    public void run() {
        System.out.print(this.ui.getGreeting());
        this.ui.printSectionLine();
        while (true) {
            String input = this.scanner.nextLine();

            this.ui.printSectionLine();

            String response = this.parser.parse(new Task(input));
            if (response.charAt(0) == '!') {
                break;
            }

            this.storage.update(this.list);
            this.storage.save();

            this.ui.printSectionLine();
        }
        this.ui.printSectionLine();
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        new Jarvis().run();
    }
}
