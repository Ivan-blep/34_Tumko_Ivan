import java.io.*;

/**
 * The class Save res
 */
public class SaveRes {

    private static final String FILE_NAME = "Ballistic_trajectory.ser";
    private static BallisticTrajectoryM resultM;
    private static BallisticTrajectoryF resultF;

    /**
     *
     * Save result
     *
     * @param bt the bt.
     */
    public static void saveResult(BallisticTrajectoryM bt) {

        resultM = bt;
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(resultM);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * Save result
     *
     * @param bt the bt.
     */
    public static void saveResult(BallisticTrajectoryF bt) {

        resultF = bt;
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(resultF);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * Gets the result M
     *
     * @return the result M
     */
    public static BallisticTrajectoryM getResultM() {

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            resultM = (BallisticTrajectoryM) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultM;
    }

    /**
     *
     * Gets the result F
     *
     * @return the result F
     */
    public static BallisticTrajectoryF getResultF() {

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            resultF = (BallisticTrajectoryF) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultF;
    }
}
