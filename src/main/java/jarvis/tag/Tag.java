package jarvis.tag;

import java.io.Serializable;

/**
 * Represents a tag that can be used to filter out tasks.
 *
 * @author Neko-Nguyen
 */
public class Tag implements Serializable {
    /** Tag description. */
    private final String description;

    /**
     * Creates a tag with a description.
     *
     * @param description tag description.
     */
    public Tag(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the tag.
     *
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tag otherTag) {
            String thisTag = this.getDescription();

            if (thisTag == null) {
                return false;
            }
            return thisTag.equals(otherTag.getDescription());
        }
        return false;
    }

    @Override
    public String toString() {
        return "#" + this.description;
    }
}
