package rio;

import rio.task.Task;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class TaskList implements Serializable {
    private List<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public int getSize() {
        return list.size();
    }

    public Task getTask(int i) {
        return list.get(i);
    }

    public void add(Task task) {
        list.add(task);
    }

    public void remove(int i) {
        list.remove(i);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
