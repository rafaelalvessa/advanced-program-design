/**
 * The class HeatingSimulation simulates the changes of temperature inside and
 * outside of the room, and the status of the heater (on or off) over a
 * period of 100 time units.
 */
public class HeatingSimulation {
    public static void main(String[] args) {
        double t = 20.0; // Temperature inside a room.
        double e = 18.0; // Temperature outside.
        double f = 0.05; // A constant factor for any particular room.
        double h = 30.0; // A constant factor for any particular heater.
        double a = 50.0; // The area of any particular room.
        double theta = 22.0; // Temperature set by a thermostat.
        double d = 2.0; // Overheat.
        double eDrop = 0.1; // Drop of outside temperature per time unit.
        int period = 100; // Period of the simulation.

        Heating simulation = new Heating(t, e, f, h, a, theta, d);

        System.out.println("Beginning of Room Heating Simulation\n");
        System.out.println("*** Initial Values ***");
        System.out.println(simulation.toString());

        for (int i = 0; i < period; i++) {
            System.out.println("*** Time Unit #" + (i + 1) + " ***");

            /* Calculate the changes of temperature and the status of
             * the heater.
             */
            simulation.calcTempChange(eDrop);
            System.out.println(simulation.toString());
        }

        System.out.println("End of Room Heating Simulation\n");
    }
}
