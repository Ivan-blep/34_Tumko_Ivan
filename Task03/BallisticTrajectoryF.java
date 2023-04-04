import java.io.Serializable;

/**
 * The class Ballistic trajectory F implements serializable
 */
public class BallisticTrajectoryF implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double distancef;

    /**
     *
     * Ballistic trajectory F
     *
     * @param initialVelocityf the initial velocityf
     * @param launchAngle      the launch angle
     * @return public
     */
    public BallisticTrajectoryF(double initialVelocityf, double launchAngle) {

        distancef = (initialVelocityf * initialVelocityf * Math.sin(2 * launchAngle) / 9.81);
    }

    /**
     *
     * Gets the distance F
     *
     * @return the distance F
     */
    public double getDistanceF() {

        return Math.round(distancef);
    }
}