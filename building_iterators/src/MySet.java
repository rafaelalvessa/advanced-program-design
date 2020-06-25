import java.util.ArrayList;
import java.util.Iterator;

public class MySet<E> {
    // OVERVIEW: Sets are unbounded mutable sets

    private ArrayList<E> els; // the rep

    // constructors
    public MySet() {
        els = new ArrayList<E>();
    }

    //methods
    public void insert(E el) {
        // MODIFIES: this
        // EFFECTS: Adds el to the elements of this
        if (getIndex(el) < 0) els.add(el);
    }

    public void remove(E el) {
        // MODIFIES: this
        // EFFECTS: Removes el from this
        int i = getIndex(el);

        if (i < 0) return;

        els.set(i, els.get(els.size() - 1));
        els.remove(els.size() - 1);
    }

    public boolean isIn(E el) {
        // EFFECTS: Returns true if el is in this else returns false
        return getIndex(el) >= 0;
    }

    private int getIndex(E el) {
        // EFFECTS: If el is in this returns index where el appears
        //          else returns -1
        for (int i = 0; i < els.size(); i++)
            if (el.equals(els.get(i))) return i;

        return -1;
    }

    public int size() {
        // EFFECTS: Returns the cardinality of this
        return els.size();
    }

    public String toString() {
        // EFFECTS: Return string representation of this
        if (els.size() == 0)
            return "{}";
        else {
            String str = "{" + els.get(0);

            for (int i = 1; i < els.size(); i++)
                str += "," + els.get(i);

            return str + "}";
        }
    }

    /**
     * Provides an iterator for elements of type E.
     *
     * @return an object of a subclass of Iterator<E>
     */
    public Iterator<E> iterator() {
        return new MySetIterator(this);
    }

    /**
     * Implementation of an iterator for the class MySet.
     *
     * @param <E> the type of the elements in the set
     */
    private class MySetIterator implements Iterator<E> {
        private MySet<E> set;
        private int index;

        /**
         * Constructs an iterator for MySet objects.
         *
         * @param set a MySet object
         */
        public MySetIterator(MySet<E> set) {
            this.set = set;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < set.size();
        }

        @Override
        public E next() {
            return set.els.get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
