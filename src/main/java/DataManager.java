import java.io.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class DataManager {
    private static final String path = "src/main/data/rio.ser";
    private List<Task> list;

    public DataManager() { }

    public void update(List<Task> list) {
        this.list = list;
    }

    public List<Task> get() {
        return this.list;
    }
    
    public void resetData() {
        this.list = new ArrayList<>();
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
            this.list = (List<Task>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
