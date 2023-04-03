import java.io.*;

/**
 * The class Main
 */
public class Main {

    /**
     * Main method
     *
     * @param args the args
     */
    public static void main(String[] args) {

        // Create object
        BallisticTrajectory bt = new BallisticTrajectory(10, 20);

        // Serialize object
        try (FileOutputStream fos = new FileOutputStream("Ballistic_trajectory.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(bt);
        } catch (IOException e) {
        }

        // Deserialize object
        try (FileInputStream fis = new FileInputStream("Ballistic_trajectory.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            BallisticTrajectory bt2 = (BallisticTrajectory) ois.readObject();
            System.out.println("Distance: " + bt2.getDistance() + " meters");
            System.out.println("Distance in feet: " + bt2.calculateDistanceOnFut() + " feet");
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
