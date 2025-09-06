package rio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

/**
 * Handles data persistence for the Rio chatbot, manages saving and
 * loading TaskList objects to/from serialized file.
 *
 * @author Neko-Nguyen
 */
public class Storage {
    private final Path path;
    private final Path pathDir;
    private TaskList list;

    /**
     * Creates Storage instance for Rio chatbot data persistence.
     * Initializes file paths for serialized task data storage.
     */
    public Storage() {
        this.path = Path.of("data/rio.ser");
        this.pathDir = Path.of(".").resolve(path.getParent()).resolve(path.getFileName());
    }

    /**
     * Updates the current list with the provided list.
     *
     * @param list the current list after the last load from the database.
     */
    public void update(TaskList list) {
        this.list = list;
    }

    /**
     * Returns the current task list.
     *
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
            FileOutputStream fos = new FileOutputStream(pathDir.toFile());
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
            File file = pathDir.toFile();
            if (!file.exists()) {
                file.createNewFile();
                resetData();
                System.out.println("    No saved data found. Starting fresh.");
                return;
            }

            FileInputStream fis = new FileInputStream(pathDir.toFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.list = (TaskList) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
