import java.text.DecimalFormat;

/**
 * The class Heating simulates a heater that is set by a thermostat. It
 * calculates the gain and loss of temperature for a period of time, and it
 * displays the temperatures inside and outside of the room as well as if the
 * heater is switched on or off.
 */
public class Heating {
    private double t; // Temperature inside a room.
    private double e; // Temperature outside.
    private double f; // A constant factor for any particular room.
    private double h; // A constant factor for any particular heater.
    private double a; // The area of any particular room.
    private double theta; // Temperature set by a thermostat.
    private double d; // Overheat.
    private boolean status; // true if heater is switched on; false otherwise.

    public Heating(double t, double e, double f, double h, double a,
            double theta, double d) {
        this.t = t;
        this.e = e;
        this.f = f;
        this.h = h;
        this.a = a;
        this.theta = theta;
        this.d = d;
        this.status = false;
    }

    /**
     * Controls the status of the heater, i.e. if the heater should be
     * switched on or off.
     *
     * @return true if the heater is switched on; false otherwise.
     */
    private boolean currentStatus() {
        if (t < theta)
            return true;
        else if (t > theta + d)
            return false;
        return status;
    }

    /**
     * Calculates the loss of temperature in the room due to heat exchange
     * through its walls for one time period.
     *
     * @return the current calculated temperature.
     */
    private double temperatureLoss() {
        return (t - e) * f;
    }

    /**
     * If the heater is switched on, calculates the gain in temperature in the
     * room due to the heater for one time period.
     *
     * @return the current calculated gain in temperature.
     */
    private double temperatureGain() {
        if (status) {
            return h / a;
        }

        return 0;
    }

    /**
     * Calculates both the gain and loss of temperature for one time period,
     * and determines whether the status of the heater is altered or not.
     *
     * @param eDrop drop of outside temperature per time unit.
     */
    public void calcTempChange(double eDrop) {
        e -= eDrop;
        t -= temperatureLoss();
        t += temperatureGain();
        status = currentStatus();
    }

    /**
     * Displays the temperatures inside and outside of the room formatted to
     * two decimal places, as well as the heater status (on or off).
     *
     * @return a string containing the current information about the system.
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        StringBuilder output = new StringBuilder();

        output.append("Inside temperature: " + df.format(t) + "\n");
        output.append("Outside temperature: " + df.format(e) + "\n");
        output.append("Heater status: ");
        output.append(status ? "On" : "Off");
        output.append("\n");

        return output.toString();
    }
}
