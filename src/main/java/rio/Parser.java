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
                ui.byeCommand();
                return false;
            }
            if (cmd == Command.list) ui.listCommand();
            else if (ui.isEnoughDescription(command.length)) return true;
            if (cmd == Command.mark) ui.markCommand(command[1]);
            if (cmd == Command.unmark) ui.unmarkCommand(command[1]);
            if (cmd == Command.todo) ui.todoCommand(command[1]);
            if (cmd == Command.deadline) ui.deadlineCommand(command[1]);
            if (cmd == Command.event) ui.eventCommand(command[1]);
            if (cmd == Command.delete) ui.deleteCommand(command[1]);
        } catch (IllegalArgumentException e) {
            ui.notRecognizeCommand();
        }
        return true;
    }
}
