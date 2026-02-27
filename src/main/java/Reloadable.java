/**
 * For GUI classes that display information, which may need to be reloaded as it updates.
 */
public interface Reloadable {
    /**
     * Reload the displayed information.
     */
    void reload();
}
