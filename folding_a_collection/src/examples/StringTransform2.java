package examples;
import java.util.*;

class StringTransform2 {
    // Demonstration of mapping a StringTransformer onto an arrayList of
    // Strings constructively. In this case, a StringTransformer which is
    // constructed with an argument.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<String>();

        System.out.print("Enter a name: ");

        String name = in.nextLine();

        System.out.println("Enter some text (terminate with an empty line):");

        String str = "";
        String line = in.nextLine();

        while (line.length() > 0) {
            String[] words = line.split(" ");

            for (String word: words)
                text.add(word);

            line = in.nextLine();
        }

        StringTransformer trans = new NameDropper1(name);
        ArrayList<String> changedText = map(trans, text);

        System.out.println("Mapping NameDropper onto the words gives:\n");

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
