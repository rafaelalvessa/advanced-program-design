package examples;

class StringLength1 implements MyComparator1 {
    // Comparator object for Strings - orders by length of String
    public int compare(Object x, Object y) {
        if (x instanceof String && y instanceof String) {
            String xstr = (String) x, ystr = (String) y;

            return xstr.length() - ystr.length();
        } else
            return 0;
    }
}
