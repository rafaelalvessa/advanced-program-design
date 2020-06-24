/**
 * This class demonstrates DogWatcher objects being added to and taken away
 * from the list of observers of DogBot and RacingDogBot objects.
 */
public class TestDogBot {
    public static void main(String[] args) {

        // Creates two DogBot objects and one RacingDogBot object.
        ObservableDogBot rex = new ObservableDogBot(new DogBot(7, 5, "Rex"));
        ObservableDogBot lucy = new ObservableDogBot(new DogBot(3, 8, "Lucy"));
        ObservableRacingDogBot max =
                new ObservableRacingDogBot(new RacingDogBot(2, 3, "Max"));

        // Creates two DogWatcher objects.
        DogWatcher alex = new DogWatcher("Alex");
        DogWatcher sam = new DogWatcher("Sam");

        // Demonstration #1
        System.out.println("*** Demonstration #1 ***");
        rex.addObserver(alex);
        rex.play();
        rex.addObserver(sam);
        rex.countObservers();
        rex.eat();

        // Demonstration #2
        System.out.println("\n*** Demonstration #2 ***");
        lucy.addObserver(sam);
        lucy.rest();

        // Demonstration #3
        System.out.println("\n*** Demonstration #3 ***");
        rex.play();
        lucy.play();

        // Demonstration #4
        System.out.println("\n*** Demonstration #4 ***");
        rex.deleteObserver(sam);
        rex.countObservers();
        rex.rest();
        System.out.println(rex.noise());

        // Demonstration #5
        System.out.println("\n*** Demonstration #5 ***");
        max.addObserver(alex);
        max.race();

        // Demonstration #6
        System.out.println("\n*** Demonstration #6 ***");
        max.addObserver(sam);
        max.countObservers();
        max.rest();

        // Demonstration #7
        System.out.println("\n*** Demonstration #7 ***");
        lucy.deleteObservers();
        lucy.countObservers();
    }
}
