import java.io.Serializable;

/**
 * The class Ballistic trajectory M implements serializable
 */
public class BallisticTrajectoryM implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double distance;

    /**
     *
     * Ballistic trajectory M
     *
     * @param initialVelocity the initial velocity
     * @param launchAngle     the launch angle
     * @return public
     */
    public BallisticTrajectoryM(double initialVelocity, double launchAngle) {

        distance = (initialVelocity * initialVelocity * Math.sin(2 * launchAngle) / 9.81);
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
}
