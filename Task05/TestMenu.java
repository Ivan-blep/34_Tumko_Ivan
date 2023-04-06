import java.util.Scanner;

public class TestMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        // Test working in meters
        System.out.println("Testing working in meters:");
        System.out.print("Enter initial velocity in meters per second: ");
        double ivM = scanner.nextDouble();
        System.out.print("Enter angle in degrees: ");
        double angleM = scanner.nextDouble();
        BallisticTrajectoryM btM = new BallisticTrajectoryM(ivM, angleM);
        TestRes.validateDistance(btM.getDistance());
        SaveRes.saveResult(btM);
        BallisticTrajectoryM btM2 = SaveRes.getResultM();
        System.out.println(btM2.toString());

        // Test working in feet
        System.out.println("Testing working in feet:");
        System.out.print("Enter initial velocity in feet per second: ");
        double ivF = scanner.nextDouble();
        System.out.print("Enter angle in degrees: ");
        double angleF = scanner.nextDouble();
        BallisticTrajectoryF btF = new BallisticTrajectoryF(ivF, angleF);
        TestRes.validateDistance(btF.getDistance());
        SaveRes.saveResult(btF);
        BallisticTrajectoryF btF2 = SaveRes.getResultF();
        System.out.println(btF2.toString());

        // Test invalid input
        System.out.println("Testing invalid input:");
        menu.run();
    }
}
