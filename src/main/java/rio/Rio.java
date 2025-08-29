/*
* File: rio.Rio.java
* Author: Neko-Nguyen
* Description:
*       Main class for the rio.Rio chatbot - a simple personal assistant
*       that helps users to manage their tasks.
* Dependencies: rio.Storage, rio.TaskList, rio.Ui, rio.Parser
*/
package rio;

import rio.task.Task;
import java.util.Scanner;

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
        list = storage.get();

        ui = new Ui(list);
        parser = new Parser(ui);
    }

    public void run() {
        ui.greeting();
        while (parser.read(new Task(scanner.nextLine()))) {
            storage.update(list);
            storage.save();

            ui.printSectionLine();
            ui.resetRecognizeCommand();
        }
        ui.printSectionLine();
    }

    public static void main(String[] args) {
        new Rio().run();
    }
}
