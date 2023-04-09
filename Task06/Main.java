// Main.java

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Main
 */
public class Main {

    /**
     *
     * Main
     *
     * @param args the args.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Введiть число або 'Q' для завершення: ");
            String input = scanner.nextLine();

            if (input.equals("Q")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Невiрний формат числа, спробуйте ще раз.");
            }
        }

        ArrayProcessor arrayProcessor = new ArrayProcessor(numbers);

        while (true) {
            System.out.print("Введіть команду (min, max, average, sum, std): ");
            String command = scanner.nextLine();

            if (command.equals("out")) {
                break;
            } else {
                WorkerThread workerThread = new WorkerThread(arrayProcessor, command);
                workerThread.start();
                try {
                    workerThread.join(); // зачекати завершення роботи потока
                    System.out.println(workerThread.getResult());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
