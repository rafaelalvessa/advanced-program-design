package examples;

class StringAlphabetic1 implements MyComparator1 {
    // Comparator object for Strings - orders by alphabetical ordering
    public int compare(Object x, Object y) {
        if (x instanceof String && y instanceof String)
            return ((String) x).compareTo((String) y);
        else
            return 0;
    }
}
