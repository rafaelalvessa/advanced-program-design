/**
 * This class is a subclass of DogBot. Beyond all the things that a DogBot can
 * do, a RacingDogBot can also race. The code was adapted from the module
 * materials given for the week 2 teaching.
 */
public class RacingDogBot extends DogBot {

    /**
     * Constructs a RacingDogBot with a name and its hungry and tired
     * properties.
     *
     * @param h a number representing how hungry the RacingDogBot is
     * @param t a number representing how tired the RacingDogBot is
     * @param n the name of the RacingDogBot
     */
    public RacingDogBot(int h, int t, String n) {
        super(h, t, n);
    }

    /**
     * The RacingDogBot races if it is not too tired.
     * @return true if the RacingDogBot raced; false otherwise
     */
    public boolean race() {
        if (tired < 5) {
            hungry += 2;
            tired += 5;

            return true;
        } else
            return false;
    }

    /**
     * The RacingDogBot rests.
     */
    public void rest() {
        hungry++;
        tired -= 3;
    }
}
