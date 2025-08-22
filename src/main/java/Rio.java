import java.util.Scanner;

public class Rio {
    static String endLine = "   ____________________________________________________________";

    public void presentation() {
        String logo = " ____  _       \n"
                + "|  _ \\(_) ___  \n"
                + "| |_) | |/ _ \\ \n"
                + "|  _ <| | |_| |\n"
                + "|_| \\_\\_|\\___/ \n";

        System.out.println("Hello from\n" + logo);
    }

    public boolean doTask(String inp) {
        if (inp.equals("bye")) {
            System.out.println("    Bye. Hope to see you again sometime soon!");
            return false;
        }
        System.out.println("    " + inp);
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rio rio = new Rio();

        System.out.println(endLine);

        System.out.println("    Hello, I'm Rio - your personal assistant.");
        System.out.println("    What can I do for you today?");

        System.out.println(endLine);

        while (rio.doTask(scanner.nextLine())) {
            System.out.println(endLine);
        }
    }
}
