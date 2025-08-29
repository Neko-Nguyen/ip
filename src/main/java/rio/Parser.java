package rio;

import rio.task.Task;

enum Command {
    bye, list, mark, unmark, todo, deadline, event, delete
}

public class Parser {
    private Ui ui;

    public Parser(Ui ui) {
        this.ui = ui;
    }

    public boolean read(Task task) {
        ui.printSectionLine();
        String[] command = task.get().split(" ", 2);
        try {
            Command cmd = Command.valueOf(command[0]);
            if (cmd == Command.bye) {
                ui.endTask();
                return false;
            }
            if (cmd == Command.list) ui.listTask();
            else if (ui.isEnoughDescription(command.length)) return true;
            if (cmd == Command.mark) ui.markTask(command[1]);
            if (cmd == Command.unmark) ui.unmarkTask(command[1]);
            if (cmd == Command.todo) ui.todoTask(command[1]);
            if (cmd == Command.deadline) ui.deadlineTask(command[1]);
            if (cmd == Command.event) ui.eventTask(command[1]);
            if (cmd == Command.delete) ui.deleteTask(command[1]);
        } catch (IllegalArgumentException e) {
            ui.recognizeCommand();
        }
        return true;
    }
}
