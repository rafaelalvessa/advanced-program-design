import java.util.Observable;
import java.util.Observer;

/**
 * This class creates an observable DogBot by using the Decorator design
 * pattern to add the observable aspects of the DogBot methods to DogBot
 * objects.
 */
public class ObservableDogBot extends Observable {
    protected DogBot db;

    /**
     * Constructs an ObservableDogBot based on a DogBot object.
     *
     * @param db a DogBot object
     */
    public ObservableDogBot(DogBot db) {
        this.db = db;
    }

    /**
     * The ObservableDogBot notifies its observers in case it has eaten.
     *
     * @return true if it has eaten; false otherwise
     */
    public boolean eat() {
        boolean hasEaten = db.eat();

        if (hasEaten) {
            setChanged();
            notifyObservers("eat");
        }

        return hasEaten;
    }

    /**
     * The DogBot rests and notifies its observers of the changes to its state.
     */
    public void rest() {
        db.rest();
        setChanged();
        notifyObservers("rest");
    }

    /**
     * The DogBot plays and notifies its observers of the changes to its state.
     */
    public void play() {
        db.play();
        setChanged();
        notifyObservers("play");
    }

    /**
     * Makes the DogBot produce a sound.
     *
     * @return the noise produced by the DogBot
     */
    public String noise() {
        return db.noise();
    }

    /**
     * Tells the name of the DogBot.
     */
    public String toString() {
        return db.toString();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        System.out.println(o + " is now observing " + db);
    }

    @Override
    public int countObservers() {
        int count = super.countObservers();

        System.out.println(db + " is being observed by " + count +
                (count == 1 ? " observer" : " observers"));

        return count;
    }

    @Override
    public void deleteObserver(Observer o) {
        super.deleteObserver(o);
        System.out.println(o + " is no longer observing " + db);
    }

    @Override
    public void deleteObservers() {
        super.deleteObservers();
        System.out.println(db + " is no longer being observed by anyone");
    }
}
