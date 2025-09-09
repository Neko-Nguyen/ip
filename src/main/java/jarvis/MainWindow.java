package jarvis;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for the main GUI.
 *
 * @author Neko-Nguyen
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    /** Jarvis chatbot instance. */
    private Jarvis jarvis;
    /** User profile image. */
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/TonyStark.png"));
    /** Jarvis profile image. */
    private Image jarvisImage = new Image(this.getClass().getResourceAsStream("/images/Jarvis.png"));

    @FXML
    public void initialize() {
        this.scrollPane.vvalueProperty().bind(this.dialogContainer.heightProperty());
    }

    /**
     * Injects the Jarvis instance.
     */
    public void setJarvis(Jarvis jarvis) {
        this.jarvis = jarvis;
        this.dialogContainer.getChildren().addAll(
                DialogBox.getJarvisDialog(this.jarvis.greet(), this.jarvisImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     *  the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = this.userInput.getText();
        String response = this.jarvis.getResponse(input);
        this.dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, this.userImage),
                DialogBox.getJarvisDialog(response, this.jarvisImage)
        );
        this.userInput.clear();

        if (response.charAt(0) == '!') {
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> System.exit(0));
            delay.play();
        }
    }
}
