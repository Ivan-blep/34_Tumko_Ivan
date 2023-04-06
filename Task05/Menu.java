import java.util.Scanner;

class Menu {
    private Scanner scanner = new Scanner(System.in);
    private char ivent;

    public void run() {
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

                    // Prompt user to save result
                    System.out.print("Do you want to save the result? (S for Save, U for Unsave): ");
                    char saveResult = scanner.next().charAt(0);

                    if (saveResult == 'S') {
                        SaveRes.saveResult(bt2);
                        System.out.println("Result saved.");
                    } else {
                        System.out.println("Result not saved.");
                    }
                } else {
                    System.out.println("Invalid distance.");
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

                    // Prompt user to save result
                    System.out.print("Do you want to save the result? (S for Save, U for Unsave): ");
                    char saveResult = scanner.next().charAt(0);

                    if (saveResult == 'S') {
                        SaveRes.saveResult(bt2);
                        System.out.println("Result saved.");
                    } else {
                        System.out.println("Result not saved.");
                    }
                } else {
                    System.out.println("Invalid distance.");
                }
            } else {
                System.out.println("Invalid input. Please enter M or F.");
            }
        }
    }
}
