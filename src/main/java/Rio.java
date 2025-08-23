import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Rio {
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
    }
    
    private void listTask() {
        System.out.println("    Here are all the tasks in your list");
        for (int i = 0; i < list.size(); ++i) {
            Task nextTask = list.get(i);
            String status = nextTask.isDone() ? "X" : " ";
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask.toString());
        }
    }
    
    private void markTask(Task task) {
        task.finish();
        System.out.println("    Nice! You've got this task done:");
        System.out.println("    " + task.toString());
    }

    private void unmarkTask(Task task) {
        task.unfinish();
        System.out.println("    Ok, I've marked this task as not done yet:");
        System.out.println("    " + task.toString());
    }

    public boolean doTask(Task task) {
        printSectionLine();

        if (task.equals(Task.of("bye"))) {
            endTask();
            return false;
        }
        if (task.equals(Task.of("list"))) {
            listTask();
            return true;
        }

        String[] parts = task.get().split(" ");
        if (parts.length == 2) {
            try {
                int index = Integer.parseInt(parts[1]);
                if (index > list.size()) {
                    System.out.println("    Oops! You don't have task number " + index);
                    return true;
                }

                task = Task.of(parts[0]);
                Task targetedTask = list.get(index - 1);
                if (task.equals(Task.of("mark"))) markTask(targetedTask);
                if (task.equals(Task.of("unmark"))) unmarkTask(targetedTask);
                return true;
            } catch (NumberFormatException e) {

            }
        }

        list.add(task);
        System.out.println("    added: " + task.get());
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rio rio = new Rio();
        rio.greeting();

        while (rio.doTask(Task.of(scanner.nextLine()))) {
            rio.printSectionLine();
        }
        rio.printSectionLine();
    }
}
