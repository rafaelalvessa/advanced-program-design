package examples;
import java.util.*;

class StringTransform5 {
    // Demonstration of mapping a Transformer onto an arrayList of
    // Strings constructively to produce an arrayList of Integers.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<String>();

        System.out.println("Enter some text (terminate with an empty line):");

        String str = "";
        String line = in.nextLine();

        while (line.length() > 0) {
            String[] words = line.split(" ");
            for (String word: words)
                text.add(word);

            line = in.nextLine();
        }

        Transformer<String, Integer> trans = new Lengther();
        ArrayList<Integer> lengths = map(trans, text);

        System.out.println("Mapping Lengther onto the words gives:\n");
        System.out.println(lengths);
    }

    public static <T1, T2> ArrayList<T2> map(Transformer<T1, T2> tr,
            List<T1> a) {
        ArrayList<T2> mapped = new ArrayList<T2>();

        for (T1 word: a)
            mapped.add(tr.transform(word));

        return mapped;
    }
}
