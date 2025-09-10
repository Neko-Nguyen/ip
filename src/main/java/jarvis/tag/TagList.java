package jarvis.tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Mimics an ArrayList to stores the tags in an array.
 *
 * @author Neko-Nguyen
 */
public class TagList implements Serializable {
    /** List of tags. */
    private List<Tag> list;

    public TagList() {
        this.list = new ArrayList<>();
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list.
     */
    public int getSize() {
        return this.list.size();
    }

    /**
     * Returns the tag in the place of the given index.
     *
     * @param index the index of the wanted tag.
     * @return the tag in the place of the given index.
     */
    public Tag getTag(int index) {
        return this.list.get(index);
    }

    /**
     * Adds the given tag to the list.
     *
     * @param tag the tag to be added to the list.
     */
    public void add(Tag tag) {
        this.list.add(tag);
    }

    /**
     * Removes the tag in the place of the given index.
     *
     * @param index the index of the tag to be removed.
     */
    public void remove(int index) {
        this.list.remove(index);
    }

    @Override
    public String toString() {
        String tags = "";
        for (int i = 0; i < this.getSize(); ++i) {
            tags += this.getTag(i) + " ";
        }
        return tags;
    }
}
