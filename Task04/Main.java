import java.util.Scanner;

/**
 * The class Main
 */
public class Main {
    /**
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

                // Validate distance
                if (TestRes.validateDistance(bt.getDistance())) {
                    // Serialize object
                    SaveRes.saveResult(bt);

                    // Deserialize object
                    BallisticTrajectoryM bt2 = SaveRes.getResultM();
                    System.out.println(bt2.toString());
                }
            } else if (ivent == 'F') {
                // Prompt user to enter initial velocity and angle
                System.out.print("Enter initial velocity in feet per second: ");
                double initialVelocity = scanner.nextDouble();

                System.out.print("Enter angle in degrees: ");
                double angle = scanner.nextDouble();

                // Create object with user input
                BallisticTrajectoryF bt = new BallisticTrajectoryF(initialVelocity, angle);

                // Validate distance
                if (TestRes.validateDistance(bt.getDistance())) {
                    // Serialize object
                    SaveRes.saveResult(bt);

                    // Deserialize object
                    BallisticTrajectoryF bt2 = SaveRes.getResultF();
                    System.out.println(bt2.toString());
                }
            } else {
                System.out.println("Invalid input. Please enter M or F.");
            }
        }
    }
}
