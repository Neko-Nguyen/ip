package rio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Storage {
    private static final String path = "src/main/data/rio.ser";
    private TaskList list;

    public void update(TaskList list) {
        this.list = list;
    }

    public TaskList get() {
        return this.list;
    }
    
    public void resetData() {
        list = new TaskList();
        save();
    }

    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
                resetData();
                System.out.println("    No saved data found. Starting fresh.");
                return;
            }

            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.list = (TaskList) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
