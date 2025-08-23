public class Task {
    private String task;
    private boolean status;

    private Task(String task) {
        this.task = task;
        this.status = false;
    }

    public static Task of(String task) {
        return new Task(task);
    }

    public String get() {
        return task;
    }

    public boolean isDone() {
        return status;
    }

    public void finish() {
        status = true;
    }

    public void unfinish() {
        status = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task otherTask = (Task) obj;
            String thisTask = this.get();

            if (thisTask == null) {
                System.out.println(1);
                return otherTask == null;
            }
            return thisTask.equals(otherTask.get());
        }
        return false;
    }

    @Override
    public String toString() {
        String stat = status ? "X" : " ";
        return "[" + stat + "] " + task;
    }
}
