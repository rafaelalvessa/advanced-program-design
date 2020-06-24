import java.util.Observable;
import java.util.Observer;

/**
 * This class implements Observer. It prints a message whenever a DogBot object
 * to which it is an observer executes a method which causes its state to
 * change.
 */
public class DogWatcher implements Observer {
    private String name;

    /**
     * Constructs a DogWatcher with a name.
     *
     * @param name the name of the DogWatcher
     */
    public DogWatcher(String name) {
        this.name = name;
    }

    /**
     * Tells the name of the watcher.
     */
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " observes " + o + " " + arg);
    }
}
