package examples;
import java.util.*;

class StringTransform1 {
    // Demonstration of mapping a StringTransformer onto an arrayList of
    // Strings constructively.

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

        StringTransformer trans = new UpperCaser1();
        ArrayList<String> changedText = map(trans,text);

        System.out.println("Mapping UpperCaser onto the words gives:\n");

        for (String word : changedText)
            System.out.println("  " + word);
    }

    public static ArrayList<String> map(StringTransformer tr, List<String> a) {
        ArrayList<String> mapped = new ArrayList<String>();

        for (String word: a)
            mapped.add(tr.transform(word));

        return mapped;
    }
}
