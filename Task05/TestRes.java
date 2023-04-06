public class TestRes {

    /**
     *
     * Validate distance
     *
     * @param distance the distance.
     * @return boolean
     */
    public static boolean validateDistance(double distance) {

        if (distance < 0) {
            System.out.println("The data is entered incorrectly!!!!!!");
            return false;
        } else {
            return true;
        }
    }
}
