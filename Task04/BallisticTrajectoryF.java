import java.io.Serializable;

/**
 * The class Ballistic trajectory F implements serializable
 */
public class BallisticTrajectoryF implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double distance;
    private final double initialVelocity;
    private final double launchAngle;

    /**
     *
     * Ballistic trajectory F
     *
     * @param initialVelocity the initial velocity.
     * @param launchAngle     the launch angle.
     * @return public
     */
    public BallisticTrajectoryF(double initialVelocity, double launchAngle) {

        this.initialVelocity = initialVelocity;
        this.launchAngle = launchAngle;
        this.distance = (initialVelocity * initialVelocity * Math.sin(2 * launchAngle) / 32.2);
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

        return "feet";
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
        sb.append(String.format("%-20s %.2f %s%n", "Initial velocity:", initialVelocity, "f/s"));
        sb.append(String.format("%-20s %.2f %s%n", "Launch angle:", launchAngle, "degrees"));
        sb.append(String.format("%-20s %.2f %s%n", "Distance:", distance, getUnit()));
        return sb.toString();
    }
}
