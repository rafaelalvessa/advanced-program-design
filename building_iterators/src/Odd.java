/**
 * The class Odd is able to filter odd Integers.
 */
public class Odd implements Checker<Integer> {
    @Override
    public boolean check(Integer obj) {
        return obj % 2 != 0;
    }
}
