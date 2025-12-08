package JavaPractice.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String [] args){

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        List<Future> futures = new ArrayList<>();
        final Random random = new Random();
        for(int x = 0; x<10; x++){
            int finalX = x;
            Callable<String> callable = () -> {
                Thread.sleep(random.nextInt(2000));
                System.out.println("Callable " + finalX + " complete");
                return "Callable " + finalX +" returned";
            };
            Future<String> future = executorService.submit(callable);
            futures.add(future);
        }

        for(Future future: futures){
            try {
                while (!future.isDone()){}
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();

    }







}
