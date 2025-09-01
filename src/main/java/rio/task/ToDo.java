package rio.task;

public class ToDo extends Task {
    public ToDo(String task) {
        super(task);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return obj instanceof ToDo;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
