import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Rio {
    private boolean recognizeCommand = false;
    private List<Task> list = new ArrayList<>();

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
        System.out.println("    Hello, I'm Rio - your personal assistant.");
        System.out.println("    What can I do for you today?");
        printSectionLine();
    }
    
    private void endTask() {
        System.out.println("    Bye. Hope to see you again sometime soon!");
        recognizeCommand = true;
    }
    
    private void listTask() {
        System.out.println("    Here are all the tasks in your list:");
        for (int i = 0; i < list.size(); ++i) {
            Task nextTask = list.get(i);
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask);
        }
        recognizeCommand = true;
    }
    
    private void markTask(String index) {
        int idx = Integer.parseInt(index);
        if (idx > list.size()) {
            System.out.println("    Oops! You don't have task number " + index);
            recognizeCommand = true;
            return;
        }
        Task targetedTask = list.get(idx - 1);
        targetedTask.finish();
        System.out.println("    Nice! You've got this task done:");
        System.out.println("    " + targetedTask);
        recognizeCommand = true;
    }

    private void unmarkTask(String index) {
        int idx = Integer.parseInt(index);
        if (idx > list.size()) {
            System.out.println("    Oops! You don't have task number " + index + ".");
            recognizeCommand = true;
            return;
        }
        Task targetedTask = list.get(idx - 1);
        targetedTask.unfinish();
        System.out.println("    Ok, I've marked this task as not done yet:");
        System.out.println("    " + targetedTask);
        recognizeCommand = true;
    }

    private void todoTask(String task) {
        Task newTask = new ToDo(task);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
        recognizeCommand = true;
    }

    private void deadlineTask(String task) {
        String[] parts = task.split("/");
        String[] deadline = parts[1].split(" ", 2);

        Task newTask = new Deadline(parts[0], deadline[1]);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
        recognizeCommand = true;
    }

    private void eventTask(String task) {
        String[] parts = task.split("/");
        String[] start = parts[1].split(" ", 2);
        String[] end = parts[2].split(" ", 2);

        Task newTask = new Event(parts[0], start[1], end[1]);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
        recognizeCommand = true;
    }

    private void deleteTask(String index) {
        int idx = Integer.parseInt(index);
        if (idx > list.size()) {
            System.out.println("    Oops! You don't have task number " + index + ".");
            recognizeCommand = true;
            return;
        }
        Task targetedTask = list.get(idx - 1);
        list.remove(idx - 1);
        System.out.println("    Sure, I've removed this task:");
        System.out.println("    " + targetedTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
        recognizeCommand = true;
    }

    public boolean doTask(Task task) {
        printSectionLine();
        String[] command = task.get().split(" ", 2);

        if (command[0].equals("bye")) {
            endTask();
            return false;
        }

        if (command[0].equals("list")) listTask();
        if (command.length == 1) {
            System.out.println("    Oops! You should add some description to your task.");
            return true;
        }

        if (command[0].equals("mark")) markTask(command[1]);
        if (command[0].equals("unmark")) unmarkTask(command[1]);
        if (command[0].equals("todo")) todoTask(command[1]);
        if (command[0].equals("deadline")) deadlineTask(command[1]);
        if (command[0].equals("event")) eventTask(command[1]);
        if (command[0].equals("delete")) deleteTask(command[1]);

        if (!recognizeCommand) {
            System.out.println("    Oops! Sorry but I don't understand. :/");
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rio rio = new Rio();

        rio.greeting();
        while (rio.doTask(new Task(scanner.nextLine()))) {
            rio.printSectionLine();
            rio.recognizeCommand = false;
        }
        rio.printSectionLine();
    }
}
