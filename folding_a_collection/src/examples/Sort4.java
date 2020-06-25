package examples;
import java.util.*;

class Sort4 {
    // Demonstration of sorting an arrayList of Strings by length
    // with the sorting generalised by using a comparator object.
    // Uses generics.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> collection = new ArrayList<String>();

        System.out.println("Enter some text (terminate with an empty line):");

        String str = "";
        String line = in.nextLine();

        while (line.length() > 0) {
            String[] words = line.split(" ");

            for (String word: words)
                collection.add(word);

            line = in.nextLine();
        }

        MyComparator2<String> comp = new StringLength2();

        sort(collection,comp);

        System.out.println("Sorting the words (alphabetically) gives:\n");

        for (String word : collection)
            System.out.println("  " + word);
    }

    public static <T> void sort(List<T> a, MyComparator2<T> comp) {
        for (int i = 0; i < a.size() - 1; i++) {
            int p = findminpos(i, a, comp);

            swap(a, i, p);
        }
    }

    private static <T> int findminpos(int start, List<T> a,
            MyComparator2<T> comp) {
        int minpos = start;

        for (int i = start + 1; i < a.size(); i++)
            if (comp.compare(a.get(i), a.get(minpos)) < 0)
                minpos = i;

        return minpos;
    }

    private static <T> void swap(List<T> a, int i, int j) {
        T temp;
        temp = a.get(i);

        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
