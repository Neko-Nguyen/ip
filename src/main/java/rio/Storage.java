package rio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * Handles data persistence for the Rio chatbot, manages saving and
 * loading TaskList objects to/from serialized file.
 * @author Neko-Nguyen
 */
public class Storage {
    private static final String path = "src/main/resources/data/rio.ser";
    private TaskList list;

    /**
     * Updates the current list with the provided list.
     * @param list the current list after the last load from the database.
     */
    public void update(TaskList list) {
        this.list = list;
    }

    /**
     * Returns the current task list.
     * @return the current TaskList instance.
     */
    public TaskList getList() {
        return this.list;
    }

    /**
     * Resets the data in the current list and in the database.
     */
    public void resetData() {
        list = new TaskList();
        save();
    }

    /**
     * Saves this.list into the database.
     */
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

    /**
     * Loads the list from the database and store it in this.list.
     */
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
