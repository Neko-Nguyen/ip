package jarvis.gui;

import java.io.IOException;

import jarvis.Jarvis;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 *
 * @author Neko-Nguyen
 */
public class Main extends Application {
    /** Jarvis chatbot instance. */
    private Jarvis jarvis = new Jarvis();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("Jarvis");
            stage.setScene(scene);

            stage.setMinHeight(220);
            stage.setMinWidth(417);

            fxmlLoader.<MainWindow>getController().setJarvis(this.jarvis);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
