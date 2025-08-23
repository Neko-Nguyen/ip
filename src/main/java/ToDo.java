public class ToDo extends Task {
    public ToDo(String task) {
        super(task);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (obj instanceof ToDo) return true;
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
