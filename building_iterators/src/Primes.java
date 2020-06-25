import java.util.*;

class Primes implements Iterator<Integer> {
    private LinkedList<Integer> primes;
    private Counter counter;

    public Primes() {
        primes = new LinkedList<Integer>();
        counter = new Counter();
        counter.next();
    }

    public boolean hasNext() {
        return true;
    }

    public Integer next() {
        int trial = counter.next();
        int i = 1;

        while (i < primes.size()) {
            i = 1;

            for (Integer p : primes)
                if (trial % p == 0) {
                    trial=counter.next();
                    break;
                } else {
                    i++;
                }
        }

        primes.add(trial);

        return trial;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
