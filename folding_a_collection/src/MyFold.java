import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the implementation of the method fold, and tests it
 * using the several join operations.
 */
public class MyFold {
    /**
     * The method main uses the several join operations to test the
     * implementation of the method fold.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        /* Sum of the integers in the collection. */
        System.out.println("*** Test #1: Sum of all integers ***");

        ArrayList<Integer> listInts = new ArrayList<Integer>();

        listInts.add(1);
        listInts.add(3);
        listInts.add(2);

        System.out.println("List: " + listInts);

        MyJoin<Integer, Integer> joinSum = new AddIntegers();
        int sum = fold(listInts, joinSum, 0);

        System.out.println("Result: " + sum);

        /* Largest integer from the collection. */
        System.out.println("\n*** Test #2: Largest integer ***");

        listInts.add(0);
        listInts.add(-5);

        System.out.println("List: " + listInts);

        MyJoin<Integer, Integer> joinMax = new MaxIntegers();
        int max = fold(listInts, joinMax, 0);

        System.out.println("Result: " + max);

        /* Length of longest string in the collection. */
        System.out.println("\n*** Test #3: Length of longest string ***");

        ArrayList<String> listStrings = new ArrayList<String>();

        listStrings.add("definition");
        listStrings.add("argument");
        listStrings.add("value");
        listStrings.add("position");

        System.out.println("List: " + listStrings);

        MyJoin<String, Integer> joinLength = new LargerIntegerString();
        int length = fold(listStrings, joinLength, 0);

        System.out.println("Result: " + length);

        /* Sort a collection of integers. */
        System.out.println("\n*** Test #4: Sort a collection of integers");
        System.out.println("List: " + listInts);

        MyJoin<Integer, List<Integer>> joinSort = new ListAddInteger();
        ArrayList<Integer> sortedList = (ArrayList<Integer>) fold(listInts,
                joinSort, new ArrayList<Integer>());

        System.out.println("Result: " + sortedList);
    }

    /**
     * The method fold takes a collection (list) of objects and an object which
     * gives a join function, and joins all the elements in the collection
     * together using this function.
     *
     * @param c a collection (list) of objects of type <T>
     * @param f a join function which performs an operation
     * @param s a value of type <S>
     * @return the result of joining all the elements in c using the function f
     */
    public static <T, S> S fold(List<T> c, MyJoin<T, S> f, S s) {
        if (c.isEmpty())
            return s;

        return f.join(c.get(0), fold(c.subList(1, c.size()), f, s));
    }
}
