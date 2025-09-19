package jarvis.ui;

/**
 * Provides predefined, stylized error message.
 *
 * @author Neko-Nguyen
 */
public class ErrorMessage {
    /** Message for when a provided task index is out of bound. */
    private static final String INVALID_TASK_INDEX = """
            \
            Sir, that index is not within the operational parameters.
            Please specify a valid task index.
            """;
    /** Message for when a provided tag index is out of bound. */
    private static final String INVALID_TAG_INDEX = """
            \
            Sir, that index is not within the operational parameters.
            Please specify a valid tag index.
            """;
    /** Message for when a task index input is not a valid integer. */
    private static final String INVALID_INDEX_FORMAT = """
            \
            Sir, an integer value is required, yet the input contains irregular symbols.
            Kindly provide a proper numeric specification.
            """;
    /** Message for an incorrect date/time format. */
    private static final String INVALID_DATETIME_FORMAT = """
            \
            Sir, please format your date and time as:
                yyyy-MM-dd HHmm
            (e.g., 2019-10-15 1800)
            Protocol requires precision.
            """;
    /** Message for an incorrect deadline date/time code. */
    private static final String INVALID_DEADLINE_DATETIME_CODE = """
            \
            Sir, please format your deadline description with starting code as:
                /by yyyy-MM-dd HHmm
            (e.g., /by 2024-09-30 2359)
            Protocol requires precision.
            """;
    /** Message for an incorrect event date/time code. */
    private static final String INVALID_EVENT_DATETIME_CODE = """
            \
            Sir, please format your event description with starting code as:
                /from yyyy-MM-dd HHmm /to yyyy-MM-dd HHmm
            (e.g., /from 2025-10-01 1400/to 2025-10-01 1500)
            Protocol requires precision.
            """;
    /** Message for when an event's start date is after its end date. */
    private static final String INVALID_EVENT_TIMELINE = """
            \
            Sir, the event's start date occurs after its end date.
            Please ensure chronological consistency by setting:
                [start] ≤ [end]
            Protocol cannot proceed with inverted timelines.
            """;
    /** Message for when the tag description is missing. */
    private static final String MISSING_TAG_DESCRIPTION = """
            \
            Sir, a tag requires a proper description to be assigned with precision.
            Kindly provide the missing specification.
            """;
    /** Message for when a deadline or event task is missing its date/time description. */
    private static final String MISSING_DATETIME_DESCRIPTION = """
            \
            Sir, both the date and time are required to be properly logged.
            Please provide the full specification.
            """;
    /** Message for when a task is missing its core description. */
    private static final String MISSING_TASK_DESCRIPTION = """
            \
            Sir, the mission parameters are incomplete.
            A task description is required to proceed.
            """;
    /** Message for when a search have no results. */
    private static final String NO_MATCHING_SEARCHES = """
            \
            Scan complete. No targets match the specified parameters, sir.
            """;
    /** Message for when the user want to list our the tasks but the list is empty. */
    private static final String EMPTY_TASK_LIST = """
            \
            Sir, the mission log is currently clear.
            No active protocols are queued for execution.
            """;
    /** Message for when the user input does not correspond to any command. */
    private static final String UNRECOGNIZABLE_COMMAND = """
            \
            Sir, that command syntax is unrecognized.
            Please rephrase your directive.
            """;

    /**
     * Retrieves the predefined error message string associated with the given error key.
     * 
     * @param error a string key representing a specific type of error.
     * @return the corresponding error message.
     */
    public String getMessage(String error) {
        return switch (error) {
            case "invalid task index" -> INVALID_TASK_INDEX;
            case "invalid tag index" -> INVALID_TAG_INDEX;
            case "invalid index format" -> INVALID_INDEX_FORMAT;
            case "invalid datetime format" -> INVALID_DATETIME_FORMAT;
            case "invalid deadline datetime code" -> INVALID_DEADLINE_DATETIME_CODE;
            case "invalid event datetime code" -> INVALID_EVENT_DATETIME_CODE;
            case "invalid event timeline" -> INVALID_EVENT_TIMELINE;
            case "missing tag description" -> MISSING_TAG_DESCRIPTION;
            case "missing datetime description" -> MISSING_DATETIME_DESCRIPTION;
            case "missing task description" -> MISSING_TASK_DESCRIPTION;
            case "no matching searches" -> NO_MATCHING_SEARCHES;
            case "empty task list" -> EMPTY_TASK_LIST;
            case "unrecognizable command" -> UNRECOGNIZABLE_COMMAND;
            default -> "";
        };
    }
}
