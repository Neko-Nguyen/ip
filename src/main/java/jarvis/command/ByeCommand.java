package jarvis.command;

/**
 * Represents a command that ends the application.
 *
 * @author Neko-Nguyen
 */
public class ByeCommand {

    /**
     * Returns a goodbye message to the user.
     *
     * @return goodbye message.
     */
    public String execute() {
        String response = "!! ";

        response += "Powering down auxiliary systems.\n"
                + "As always, a pleasure to serve, sir.\n";

        return response;
    }
}
