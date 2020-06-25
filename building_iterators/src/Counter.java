import java.util.Iterator;

class Counter implements Iterator<Integer> {
    int count;

    public Counter() {
        count = 1;
    }

    public boolean hasNext() {
        return true;
    }

    public Integer next() {
        return count++;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
