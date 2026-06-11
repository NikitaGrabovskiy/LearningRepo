package JavaPractice.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {

    public static void main(String[] args) {

        try(ExecutorService executorService = Executors.newFixedThreadPool(10)){

            Random random = new Random();
            for (int x = 0; x < 10; x++){
                final int finalX = x;
                Runnable runnable = () -> {
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(" Runnable complete " + finalX);
                };
                executorService.execute(runnable);
            }
        }

    }


}
