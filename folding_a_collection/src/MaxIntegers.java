/**
 * This class is an implementation of the MyJoin operation which takes two
 * integers and returns the largest.
 */
public class MaxIntegers implements MyJoin<Integer, Integer> {
    @Override
    public Integer join(Integer num1, Integer num2) {
        return (num1 > num2) ? num1 : num2;
    }
}
