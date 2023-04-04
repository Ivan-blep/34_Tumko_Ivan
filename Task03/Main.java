import java.io.*;
import java.util.Scanner;

/**
 * The class Main
 */
public class Main {
    /**
     *
     * Main
     *
     * @param args the args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char ivent;

        while (true) {
            System.out.print("Enter M if you want to work in meters or F if you want to work in feet (Q to quit): ");
            ivent = scanner.next().charAt(0);

            if (ivent == 'Q') {
                break;
            }

            if (ivent == 'M') {
                // Prompt user to enter initial velocity and angle
                System.out.print("Enter initial velocity in meters per second: ");
                double initialVelocity = scanner.nextDouble();

                System.out.print("Enter angle in degrees: ");
                double angle = scanner.nextDouble();

                // Create object with user input
                BallisticTrajectoryM bt = new BallisticTrajectoryM(initialVelocity, angle);

                // Serialize object
                try (FileOutputStream fos = new FileOutputStream("Ballistic_trajectory.sre");
                        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(bt);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                // Deserialize object
                try (FileInputStream fis = new FileInputStream("Ballistic_trajectory.sre");
                        ObjectInputStream ois = new ObjectInputStream(fis)) {
                    BallisticTrajectoryM bt2 = (BallisticTrajectoryM) ois.readObject();
                    System.out.println("Distance: " + bt2.getDistance() + " meters");
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            else if (ivent == 'F') {
                // Prompt user to enter initial velocity and angle
                System.out.print("Enter initial velocity in feet per second: ");
                double initialVelocity = scanner.nextDouble();

                System.out.print("Enter angle in degrees: ");
                double angle = scanner.nextDouble();

                // Create object with user input
                BallisticTrajectoryF bt = new BallisticTrajectoryF(initialVelocity, angle);

                // Serialize object
                try (FileOutputStream fos = new FileOutputStream("Ballistic_trajectory.sre");
                        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(bt);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                // Deserialize object
                try (FileInputStream fis = new FileInputStream("Ballistic_trajectory.sre");
                        ObjectInputStream ois = new ObjectInputStream(fis)) {
                    BallisticTrajectoryF bt2 = (BallisticTrajectoryF) ois.readObject();
                    System.out.println("Distance in feet: " + bt2.getDistanceF() + " feet");
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
