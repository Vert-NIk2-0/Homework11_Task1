public class PrintNumbersRunnable implements Runnable {
    public static int number = 0;
    private static final Object FLAG = new Object();

    @Override
    public void run() {
        printNumber();
    }

    private void printNumber() {
        while (number <= 100) {
            synchronized (FLAG) {
                System.out.println(Thread.currentThread().getName() + ": " + number++);
                FLAG.notify();
                try {
                    if (number <= 100) {
                        FLAG.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
