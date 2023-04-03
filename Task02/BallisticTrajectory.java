import java.io.Serializable;

/**
 * Клас, який реалізує серіалізовану балістичну траєкторію.
 */
public class BallisticTrajectory implements Serializable {

    private static final long serialVersionUID = 1L;
    private final double distance;

    /**
     * Створює об'єкт балістичної траєкторії.
     *
     * @param initialVelocity початкова швидкість
     * @param launchAngle     кут запуску
     */
    public BallisticTrajectory(double initialVelocity, double launchAngle) {
        distance = (initialVelocity * initialVelocity * Math.sin(2 * launchAngle) / 9.81);
    }

    /**
     * Повертає дистанцію, яку подолав снаряд.
     *
     * @return дистанція
     */
    public double getDistance() {
        return Math.round(distance);
    }

    /**
     * Обчислює загальну дистанцію, пройдену снарядом в метрах.
     *
     * @return загальна дистанція
     */
    public double calculateDistanceOnFut() {
        double totalDistance = getDistance() * 3.28084;
        return Math.round(totalDistance);
    }
}
