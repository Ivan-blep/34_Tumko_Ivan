import java.io.*;

/**
 * Клас {@code BallisticTrajectoryDemo} демонструє серіалізацію та
 * десеріалізацію.
 */
public class BallisticTrajectoryDemo {

    /**
     *
     * Main
     *
     * @param args the args
     */
    public static void main(String[] args) {

        BallisticTrajectory bt = new BallisticTrajectory(10, 20);

        // серіалізація
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ballistic_trajectory.ser"))) {
            out.writeObject(bt);
        } catch (IOException e) {
        }

        // десеріалізація
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Ballistic_trajectory.ser"))) {
            BallisticTrajectory bt2 = (BallisticTrajectory) in.readObject();
            System.out.println(bt2);
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}