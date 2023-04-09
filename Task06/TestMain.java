// TestMain.java

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        // Тестування функціональності ArrayProcessor
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(1);
        numbers.add(8);
        numbers.add(4);
        ArrayProcessor arrayProcessor = new ArrayProcessor(numbers);

        assert arrayProcessor.getMin() == 1;
        assert arrayProcessor.getMax() == 8;
        assert arrayProcessor.getAverage() == 4.6;
        assert arrayProcessor.getSum() == 23;
        assert arrayProcessor.getStandardDeviation() == 2.561249694973139;

        // Тестування функціональності WorkerThread
        ArrayProcessor arrayProcessor1 = new ArrayProcessor(numbers);

        WorkerThread workerThread1 = new WorkerThread(arrayProcessor1, "min");
        workerThread1.start();
        try {
            workerThread1.join();
            assert workerThread1.getResult().equals("Мiнiмальне значення: 1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayProcessor arrayProcessor2 = new ArrayProcessor(numbers);

        WorkerThread workerThread2 = new WorkerThread(arrayProcessor2, "max");
        workerThread2.start();
        try {
            workerThread2.join();
            assert workerThread2.getResult().equals("Максимальне значення: 8");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayProcessor arrayProcessor3 = new ArrayProcessor(numbers);

        WorkerThread workerThread3 = new WorkerThread(arrayProcessor3, "average");
        workerThread3.start();
        try {
            workerThread3.join();
            assert workerThread3.getResult().equals("Середнє значення: 4.6");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayProcessor arrayProcessor4 = new ArrayProcessor(numbers);

        WorkerThread workerThread4 = new WorkerThread(arrayProcessor4, "sum");
        workerThread4.start();
        try {
            workerThread4.join();
            assert workerThread4.getResult().equals("Сума: 23");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayProcessor arrayProcessor5 = new ArrayProcessor(numbers);

        WorkerThread workerThread5 = new WorkerThread(arrayProcessor5, "std");
        workerThread5.start();
        try {
            workerThread5.join();
            assert workerThread5.getResult().equals("Стандартне вiдхилення: 2.561249694973139");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}