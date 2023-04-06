import java.io.Serializable;

/**
 * The class Ballistic trajectory M implements serializable
 */
public class BallisticTrajectoryM implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double distance;
    private final double initialVelocity;
    private final double launchAngle;

    /**
     *
     * Ballistic trajectory M
     *
     * @param initialVelocity the initial velocity.
     * @param launchAngle     the launch angle.
     * @return public
     */
    public BallisticTrajectoryM(double initialVelocity, double launchAngle) {

        this.initialVelocity = initialVelocity;
        this.launchAngle = launchAngle;
        this.distance = (initialVelocity * initialVelocity * Math.sin(2 * launchAngle) / 9.81);
    }

    /**
     *
     * Gets the distance
     *
     * @return the distance
     */
    public double getDistance() {

        return Math.round(distance);
    }

    /**
     *
     * Gets the unit
     *
     * @return the unit
     */
    public String getUnit() {

        return "meters";
    }

    @Override

    /**
     *
     * To string
     *
     * @return String
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %.2f %s%n", "Initial velocity:", initialVelocity, "m/s"));
        sb.append(String.format("%-20s %.2f %s%n", "Launch angle:", launchAngle, "degrees"));
        sb.append(String.format("%-20s %.2f %s%n", "Distance:", distance, getUnit()));
        return sb.toString();
    }
}
