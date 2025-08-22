public class Task {
    private String task;

    private Task(String task) {
        this.task = task;
    }

    public static Task of(String task) {
        return new Task(task);
    }

    public String get() {
        return task;
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
}
