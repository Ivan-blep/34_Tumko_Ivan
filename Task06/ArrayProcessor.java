import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class Array processor
 */
public class ArrayProcessor {
    private List<Integer> numbers;

    /**
     *
     * It is a constructor.
     *
     * @param numbers the numbers.
     */
    public ArrayProcessor(List<Integer> numbers) {

        this.numbers = numbers;
    }

    /**
     *
     * Gets the min
     *
     * @return the min
     */
    public int getMin() {

        return Collections.min(numbers);
    }

    /**
     *
     * Gets the max
     *
     * @return the max
     */
    public int getMax() {

        return Collections.max(numbers);
    }

    /**
     *
     * Gets the average
     *
     * @return the average
     */
    public double getAverage() {

        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    /**
     *
     * Gets the greater than
     *
     * @param threshold the threshold.
     * @return the greater than
     */
    public List<Integer> getGreaterThan(int threshold) {

        return numbers.stream().filter(num -> num > threshold).collect(Collectors.toList());
    }

    /**
     *
     * Gets the less than
     *
     * @param threshold the threshold.
     * @return the less than
     */
    public List<Integer> getLessThan(int threshold) {

        return numbers.stream().filter(num -> num < threshold).collect(Collectors.toList());
    }

    /**
     *
     * Gets the sum
     *
     * @return the sum
     */
    public int getSum() {

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     *
     * Gets the standard deviation
     *
     * @return the standard deviation
     */
    public double getStandardDeviation() {

        double mean = getAverage();
        double variance = numbers.stream().mapToDouble(num -> Math.pow(num - mean, 2)).average().orElse(0.0);
        return Math.sqrt(variance);
    }
}
