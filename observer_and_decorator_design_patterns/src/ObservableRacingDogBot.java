/**
 * This class is a subclass of ObservableDogBot, which in turn is a subclass of
 * the class Observable. Therefore, all ObservableDogBot objects are observable.
 * It creates an observable RacingDogBot by using the Decorator design pattern
 * to add the observable aspects of the RacingDogBot methods to RacingDogBot
 * objects.
 */
public class ObservableRacingDogBot extends ObservableDogBot {
    protected RacingDogBot rdb;

    /**
     * Constructs an ObservableRacingDogBot based on a RacingDogBot object.
     *
     * @param rdb a RacingDogBot object
     */
    public ObservableRacingDogBot(RacingDogBot rdb) {
        super(rdb);
        this.rdb = rdb;
    }

    /**
     * The ObservableRacingDogBot notifies its observers in case it has raced.
     *
     * @return true if it has raced; false otherwise
     */
    public boolean race() {
        boolean hasRaced = rdb.race();

        if (hasRaced) {
            setChanged();
            notifyObservers("race");
        }

        return hasRaced;
    }

    /**
     * The RacingDogBot rests and notifies its observers of the changes to its
     * state.
     */
    public void rest() {
        rdb.rest();
        setChanged();
        notifyObservers("rest");
    }
}
