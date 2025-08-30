package rio.task;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (obj instanceof Deadline) return true;
            return false;
        }
        return false;
    }

    @Override
    public String toString() {

        return "[D]" + super.toString() + "(by: " + deadline + ")";
    }
}
