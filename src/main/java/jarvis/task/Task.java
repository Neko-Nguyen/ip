package jarvis.task;

import java.io.Serializable;

import jarvis.tag.Tag;
import jarvis.tag.TagList;

/**
 * Represents a general task that can be marked as finished or
 * unfinished.
 *
 * @author Neko-Nguyen
 */
public class Task implements Serializable {
    /** Task description. */
    private String description;
    /** Task status. */
    private boolean status;
    /** List of tags. */
    private TagList tags;

    /**
     * Creates a task with a description.
     * Initial status is set to unfinished (false).
     * Initiate tag list.
     *
     * @param description task description.
     */
    public Task(String description) {
        this.description = description;
        this.status = false;
        this.tags = new TagList();
    }

    /**
     * Gets the description of the task.
     *
     * @return the task description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Marks as finished.
     */
    public void markAsDone() {
        this.status = true;
    }

    /**
     * Marks as unfinished.
     */
    public void markAsUndone() {
        this.status = false;
    }

    /**
     * Checks if the description contains a certain substring.
     *
     * @param substring the substring to be checked
     * @return {@code true} if the description contains the substring, {@code false} if
     *  otherwise
     */
    public boolean doesContain(String substring) {
        return this.description.contains(substring);
    }

    /**
     * Adds the given tag to the tag list.
     */
    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    /**
     * Checks if the tag list has a similar tag with the given description.
     *
     * @param description the description of the tag to be found
     * @return {@code true} if there is a tag that matches the description, {@code fasle} if
     *  otherwise
     */
    public boolean hasTag(String description) {
        Tag tmpTag = new Tag(description);
        for (int i = 0; i < this.tags.getSize(); ++i) {
            if (this.tags.getTag(i).equals(tmpTag)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String stat = this.status ? "X" : " ";
        return "[" + stat + "] " + this.description + " " + this.tags + "\n";
    }
}
