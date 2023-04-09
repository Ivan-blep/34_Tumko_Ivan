public class WorkerThread extends Thread {
    private ArrayProcessor arrayProcessor;
    private String command;
    private Object result; // add this field to store the result of the command

    public WorkerThread(ArrayProcessor arrayProcessor, String command) {
        this.arrayProcessor = arrayProcessor;
        this.command = command;
    }

    @Override
    public void run() {
        switch (command) {
            case "min":
                int min = arrayProcessor.getMin();
                result = "Мiнiмальне значення: " + min;
                break;
            case "max":
                int max = arrayProcessor.getMax();
                result = "Максимальне значення: " + max;
                break;
            case "average":
                double average = arrayProcessor.getAverage();
                result = "Середнє значення: " + average;
                break;
            case "sum":
                int sum = arrayProcessor.getSum();
                result = "Сума: " + sum;
                break;
            case "std":
                double std = arrayProcessor.getStandardDeviation();
                result = "Стандартне вiдхилення: " + std;
                break;
            default:
                result = "Невiдома команда.";
                break;
        }
    }

    public Object getResult() { // add this method to return the result of the command
        return result;
    }
}