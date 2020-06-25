package examples;
import java.util.*;

class Sort2 {
    // Demonstration of sorting an arrayList of Strings by length
    // with the sorting generalised by using a comparator object.
    // Generics not used.

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

        MyComparator1 comp = new StringLength1();

        sort(collection, comp);

        System.out.println("Sorting the words (alphabetically) gives:\n");

        for (Object word : collection)
            System.out.println("  " + word);
    }

    public static void sort(List<String> a, MyComparator1 comp) {
        for (int i = 0; i < a.size() - 1; i++) {
            int p = findminpos(i, a, comp);

            swap(a, i, p);
        }
    }

    private static int findminpos(int start, List a, MyComparator1 comp) {
        int minpos = start;

        for (int i = start + 1; i < a.size(); i++)
            if (comp.compare(a.get(i), a.get(minpos)) < 0)
                minpos = i;

        return minpos;
    }

    private static void swap(List<String> a, int i, int j) {
        String temp;
        temp = a.get(i);

        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
