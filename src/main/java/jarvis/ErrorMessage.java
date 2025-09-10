package jarvis;

/**
 * Provides predefined, stylized error message.
 *
 * @author Neko-Nguyen
 */
public class ErrorMessage {
    /** Message for when a provided task index is out of bound. */
    private static final String INVALID_INDEX = ""
            + "Sir, that index is not within the operational parameters.\n"
            + "Please specify a valid task identifier.\n";
    /** Message for when a task index input is not a valid integer. */
    private static final String INVALID_INDEX_FORMAT = ""
            + "Sir, an integer value is required, yet the input contains irregular symbols.\n"
            + "Kindly provide a proper numeric specification.\n";
    /** Message for an incorrect date/time format. */
    private static final String INVALID_DATETIME_FORMAT = ""
            + "Sir, please format your date and time as yyyy-MM-dd HHmm\n"
            + "(e.g., 2019-10-15 1800). Protocol requires precision.\n";
    /** Message for when the tag description is missing. */
    private static final String MISSING_TAG_DESCRIPTION = ""
            + "Sir, a tag requires a proper description to be assigned with precision.\n"
            + "Kindly provide the missing specification.\n";
    /** Message for when a deadline or event task is missing its date/time description. */
    private static final String MISSING_DATETIME_DESCRIPTION = ""
            + "Sir, both the date and time are required to be properly logged.\n"
            + "Please provide the full specification.\n";
    /** Message for when a task is missing its core description. */
    private static final String MISSING_TASK_DESCRIPTION = ""
            + "Sir, the mission parameters are incomplete.\n"
            + "A task description is required to proceed.\n";
    /** Message for when a search have no results. */
    private static final String NO_MATCHING_SEARCHES = ""
            + "Scan complete. No targets match the specified parameters, sir.\n";
    /** Message for when the user want to list our the tasks but the list is empty. */
    private static final String EMPTY_TASK_LIST = ""
            + "Sir, the mission log is currently clear.\n"
            + "No active protocols are queued for execution.\n";
    /** Message for when the user input does not correspond to any command. */
    private static final String UNRECOGNIZABLE_COMMAND = ""
            + "Sir, that command syntax is unrecognized.\n"
            + "Please rephrase your directive.\n";

    /**
     * Retrieves the predefined error message string associated with the given error key.
     * 
     * @param error a string key representing a specific type of error.
     * @return the corresponding error message.
     */
    public String getMessage(String error) {
        switch (error) {
        case "invalid index": return INVALID_INDEX;
        case "invalid index format": return INVALID_INDEX_FORMAT;
        case "invalid datetime format": return INVALID_DATETIME_FORMAT;
        case "missing tag description": return MISSING_TAG_DESCRIPTION;
        case "missing datetime description": return MISSING_DATETIME_DESCRIPTION;
        case "missing task description": return MISSING_TASK_DESCRIPTION;
        case "no matching searches": return NO_MATCHING_SEARCHES;
        case "empty task list": return EMPTY_TASK_LIST;
        case "unrecognizable command": return UNRECOGNIZABLE_COMMAND;
        }
        return "";
    }
}
