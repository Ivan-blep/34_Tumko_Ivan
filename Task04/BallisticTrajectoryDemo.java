import java.io.*;

/**
 * The class Ballistic trajectory demo
 */
public class BallisticTrajectoryDemo {

    /**
     *
     * Main
     *
     * @param args the args
     */
    public static void main(String[] args) {

        BallisticTrajectoryM bt = new BallisticTrajectoryM(10, 20);

        // серіалізація
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ballistic_trajectory.ser"))) {
            out.writeObject(bt);
        } catch (IOException e) {
        }

        // десеріалізація
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Ballistic_trajectory.ser"))) {
            BallisticTrajectoryM bt2 = (BallisticTrajectoryM) in.readObject();
            System.out.println(bt2);
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}