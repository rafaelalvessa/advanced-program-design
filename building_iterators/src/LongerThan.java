/**
 * The class LargerThan is able to filter Strings by length using the interface
 * Checker.
 */
public class LongerThan implements Checker<String> {
    private int size;

    /**
     * Constructs a new LongerThan object which specified the length of the
     * Strings to filter.
     *
     * @param n the limit of the String length
     */
    public LongerThan(int n) {
        size = n;
    }

    @Override
    public boolean check(String obj) {
        return obj.length() > size;
    }
}
