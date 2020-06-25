/**
 * This is an implementation of the MyJoin operation which takes a string and
 * an integer, and returns whichever is the largest: the integer it takes or the
 * length of the string it takes.
 */
public class LargerIntegerString implements MyJoin<String, Integer> {
    @Override
    public Integer join(String str, Integer num) {
        int length = str.length();

        return (num > length) ? num : length;
    }
}
