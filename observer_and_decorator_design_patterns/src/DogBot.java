/**
 * This class represents a DogBot, which can be hungry and tired. It can also
 * eat, rest, play and make a noise. The code was adapted from the module
 * materials given for the week 2 teaching.
 */
public class DogBot {
    protected int hungry, tired;
    protected String name;

    /**
     * Constructs a DogBot with a name and its hungry and tired properties.
   *
     * @param h a number representing how hungry the DogBot is
     * @param t a number representing how tired the DogBot is
     * @param n the name of the DogBot
     */
    public DogBot(int h, int t, String n) {
        hungry = h;
        tired = t;
        name = n;
    }

    /**
     * The DogBot eats if it is hungry.
   *
     * @return true if the DogBot ate; false otherwise
     */
    public boolean eat() {
        if (hungry > 6) {
            hungry -= 3;
            return true;
        } else
            return false;
    }

    /**
     * The DogBot rests.
     */
    public void rest() {
        hungry++;
        tired -= 2;
    }

    /**
     * The DogBot plays.
     */
    public void play() {
        hungry += 2;
        tired += 3;
    }

    /**
     * Makes the DogBot produce a noise.
   *
     * @return the noise produced by the DogBot
     */
    public String noise() {
        if (hungry > 8 && tired < 11)
            return "whine ";
        else if (tired > 7 && tired > hungry)
            return "snore ";
        else
            return "woof ";
    }

    /**
     * Tells the name of the DogBot.
     */
    public String toString() {
        return name;
    }
}
