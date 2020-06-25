package examples;

class StringLength2 implements MyComparator2<String> {
    // Comparator object for Strings - orders by length of String
    public int compare(String str1,String str2) {
        return str1.length() - str2.length();
    }
}
