import java.io.*;

public class BallisticTrajectoryTest {

    /**
     * Клас {@code BallisticTrajectoryDemo} демонструє серіалізацію та
     * десеріалізацію об'єктів класу {@link BallisticTrajectory}.
     */
    public void testElectricResistance() {

        BallisticTrajectory bt = new BallisticTrajectory(10, 20);

        // перевірка результату обчислень
        assertEquals(24.0, bt.getDistance(), 0.0001);

        // перевірка серіалізації та десеріалізації
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeObject(bt);
            byte[] bytes = out.toByteArray();
            try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
                    ObjectInputStream ois = new ObjectInputStream(in)) {
                BallisticTrajectory bt2 = (BallisticTrajectory) ois.readObject();
                assertEquals(bt.getDistance(), bt2.getDistance(), 0.0001);
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    /**
     *
     * Assert equals
     *
     * @param d          the d
     * @param resistance the resistance
     * @param d0         the d0
     */
    private void assertEquals(double d, double resistance, double d0) {

        throw new UnsupportedOperationException("Not supported yet.");

    }

}