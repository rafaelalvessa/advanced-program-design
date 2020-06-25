import java.util.Iterator;

/**
 * The class Filter provides an iterator which produces a filtered run through
 * the elements of a MySet object.
 *
 * @param <E> the type of the elements in the set
 */
public class Filter<E> implements Iterator<E> {
    Iterator<E> iterator;
    Checker<E> checker;
    E element;

    /**
     * Constructs an iterator which returns filtered results.
     *
     * @param iterator an object of class Iterator
     * @param checker an object of class Checker
     */
    public Filter(Iterator<E> iterator, Checker<E> checker) {
        this.iterator = iterator;
        this.checker = checker;
    }

    @Override
    public boolean hasNext() {
        if (!iterator.hasNext())
            return false;

        element = iterator.next();

        while (!checker.check(element) && iterator.hasNext())
            element = iterator.next();

        return checker.check(element);
    }

    @Override
    public E next() {
        /* If this method is called when there are no more element to return,
         * the exception NoSuchElementException is thrown.
         */
        while (!checker.check(element))
            element = iterator.next();

        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
