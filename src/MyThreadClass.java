public class MyThreadClass {

    public static void main(String[] args) {
        PrintNumbersRunnable pr = new PrintNumbersRunnable();
        Thread tread1 = new Thread(pr, "Поток 1");
        Thread tread2 = new Thread(pr, "Поток 2");

        tread1.start();
        tread2.start();


    }
}
