import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Rio {
    private List<Task> list = new ArrayList<>();
    private Task endTask = Task.of("bye");
    private Task listTask = Task.of("list");

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

    public boolean doTask(Task task) {
        printSectionLine();

        if (task.equals(endTask)) {
            System.out.println("    Bye. Hope to see you again sometime soon!");
            return false;
        }

        if (task.equals(listTask)) {
            for (int i = 0; i < list.size(); ++i) {
                Task nextTask = list.get(i);
                String num = String.valueOf(i + 1);
                System.out.println("    " + num + ". " + nextTask.get());
            }
            return true;
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
    }
}
