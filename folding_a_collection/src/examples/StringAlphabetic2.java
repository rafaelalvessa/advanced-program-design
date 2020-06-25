package examples;

class StringAlphabetic2 implements MyComparator2<String> {
    // Comparator object for Strings - orders by alphabetical ordering
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}
