/**
 * This provides a generic interface for the range of operations performed by
 * the method join().
 *
 * @param <T> the type of the first argument
 * @param <S> the type of the second argument and returned object
 */
public interface MyJoin<T, S> {
    /**
     * This method can perform a range of operations such as:
     *
     * 1. Add two integers;
     * 2. Return the maximum of two integers;
     * 3. Takes an integer and a string, and returns whichever is the larger:
     * the integer it takes or the length of the string it takes;
     * 4. Insert an integer into the correct position in an ordered list of
     * integers.
     *
     * @param arg1 the first argument of type <T>
     * @param arg2 the second argument of type <S>
     * @return an object of type <S>
     */
    public S join(T arg1, S arg2);
}
