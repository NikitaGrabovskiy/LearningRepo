package JavaPractice.TO_PRINT.DesignPatterns;

public class DeadlockExample {

    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (LOCK_1){
                System.out.println("Thread 1 locked : LOCK_1 ");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (LOCK_2){
                    System.out.println("Thread 1 locked : LOCK_2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (LOCK_2){
                System.out.println("Thread 2 locked: LOCK 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (LOCK_1){
                    System.out.println("Thread 2 locked: LOCK 1");
                }

            }
        });

        thread1.start();
        thread2.start();
    }

}
