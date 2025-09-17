package jarvis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

import jarvis.task.TaskList;

/**
 * Handles data persistence for the Jarvis chatbot, manages saving and
 * loading TaskList objects to/from serialized file.
 *
 * @author Neko-Nguyen
 */
public class Storage {
    /** Full path to the data file. */
    private final Path pathDir;
    /** List of tasks. */
    private TaskList list;

    /**
     * Creates Storage instance for Jarvis chatbot data persistence.
     * Initializes file paths for serialized task data storage.
     */
    public Storage() {
        Path path = Path.of("data/jarvis.ser");
        this.pathDir = Path.of(".")
                .resolve(path.getParent())
                .resolve(path.getFileName());
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
        this.list = new TaskList();
        this.save();
    }

    /**
     * Saves this.list into the database.
     */
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(this.pathDir.toFile());
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
            File file = this.pathDir.toFile();
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                this.resetData();
                System.out.println("    No saved data found. Starting fresh.");
                return;
            }

            FileInputStream fis = new FileInputStream(this.pathDir.toFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.list = (TaskList) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
