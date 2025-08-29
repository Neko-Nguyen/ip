public class Ui {
    private boolean recognizeCommand = false;
    private TaskList list;

    public Ui(TaskList list) {
        this.list = list;
    }

    public void resetRecognizeCommand() {
        recognizeCommand = false;
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
        System.out.println("    Hello, I'm Rio - your personal assistant.");
        System.out.println("    What can I do for you today?");
        printSectionLine();
    }

    public void endTask() {
        recognizeCommand = true;
        System.out.println("    Bye. Hope to see you again sometime soon!");
    }

    public void listTask() {
        recognizeCommand = true;
        if (!hasTasksInList()) return;

        System.out.println("    Here are all the tasks in your list:");
        for (int i = 0; i < list.size(); ++i) {
            Task nextTask = list.get(i);
            String num = String.valueOf(i + 1);
            System.out.println("    " + num + "." + nextTask);
        }
    }

    public void markTask(String index) {
        recognizeCommand = true;
        int idx = Integer.parseInt(index);
        if (isValidTaskNum(idx)) return;

        Task targetedTask = list.get(idx - 1);
        targetedTask.finish();
        System.out.println("    Nice! You've got this task done:");
        System.out.println("    " + targetedTask);
    }

    public void unmarkTask(String index) {
        recognizeCommand = true;
        int idx = Integer.parseInt(index);
        if (isValidTaskNum(idx)) return;

        Task targetedTask = list.get(idx - 1);
        targetedTask.unfinish();
        System.out.println("    Ok, I've marked this task as not done yet:");
        System.out.println("    " + targetedTask);
    }

    public void todoTask(String task) {
        recognizeCommand = true;
        Task newTask = new ToDo(task);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
    }

    public void deadlineTask(String task) {
        recognizeCommand = true;
        String[] parts = task.split("/");
        String[] deadline = parts[1].split(" ", 2);

        Task newTask = new Deadline(parts[0], deadline[1]);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
    }

    public void eventTask(String task) {
        recognizeCommand = true;
        String[] parts = task.split("/");
        String[] start = parts[1].split(" ", 2);
        String[] end = parts[2].split(" ", 2);

        Task newTask = new Event(parts[0], start[1], end[1]);
        list.add(newTask);
        System.out.println("    Added: " + newTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
    }

    public void deleteTask(String index) {
        recognizeCommand = true;
        int idx = Integer.parseInt(index);
        if (isValidTaskNum(idx)) return;

        Task targetedTask = list.get(idx - 1);
        list.remove(idx - 1);
        System.out.println("    Sure, I've removed this task:");
        System.out.println("    " + targetedTask);
        System.out.println("    Now you have " + list.size() + " task" + (list.size() == 1 ? "" : "s") + " in your list.");
    }

    public boolean isValidTaskNum(int index) {
        if (index <= 0) {
            System.out.println("    Oops! Please input a valid task number");
            return true;
        }
        if (index > list.size()) {
            System.out.println("    Oops! You don't have task number " + index);
            return true;
        }
        return false;
    }

    public boolean isEnoughDescription(int numOfWords) {
        if (numOfWords == 1) {
            System.out.println("    Oops! You should add some description to your task.");
            return true;
        }
        return false;
    }

    public void recognizeCommand() {
        if (!recognizeCommand) {
            System.out.println("    Oops! Sorry but I don't understand. :/");
        }
    }

    public boolean hasTasksInList() {
        if (list.isEmpty()) {
            System.out.println("    Oops! Looks like there are no tasks in your list. ^^");
            return false;
        }
        return true;
    }
}
