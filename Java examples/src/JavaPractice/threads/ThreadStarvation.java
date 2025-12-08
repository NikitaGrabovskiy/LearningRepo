package JavaPractice.threads;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStarvation {


    //unfair lock by default (no 'true' in constructor)
    private static final ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {


        Runnable longRunningTask = () -> {

            while (true){
                lock.lock();

                try {
                    System.out.println(Thread.currentThread().threadId() + "GOT_LOCK");
                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            }
        };

        for (int x = 0; x<3;x++){
            Thread thread = new Thread(longRunningTask,"Worker-"+1);
            thread.start();
        }

        Runnable starvedThread = () -> {

            while (true){
                lock.lock();

                try {
                    System.out.println("Starved thread got lock");
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread thread = new Thread(starvedThread,"Starved thread");
        thread.start();

    }



}
