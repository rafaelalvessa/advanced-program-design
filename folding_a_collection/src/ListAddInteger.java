import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of the MyJoin operation which takes an
 * integer and an ordered list of integers, and returns a new list with the
 * integer inserted into the correct position.
 */
public class ListAddInteger implements MyJoin<Integer, List<Integer>> {
    @Override
    public ArrayList<Integer> join(Integer num, List<Integer> list) {
        ArrayList<Integer> orderedList = new ArrayList<Integer>(list);

        /* Adds num to the end of orderedList if list is empty or if num is
         * greater than any element of list.
         */
        if (list.isEmpty() || num >= list.get(list.size() - 1)) {
            orderedList.add(num);

            return orderedList;
        }

        boolean inserted = false;
        int i = 0;

        while (!inserted) {
            if (num <= list.get(i)) {
                orderedList.add(i, num);
                inserted = true;
            }

            i++;
        }

        return orderedList;
    }
}
