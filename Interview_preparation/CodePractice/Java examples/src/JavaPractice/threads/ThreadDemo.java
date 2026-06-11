package JavaPractice.threads;

public class ThreadDemo {

    public static void main(String[] args) {

        Thread thread = new ThreadExample();
        thread.start();

        Thread thread1 = new Thread(new RunnableExample());
        thread1.start();

    }
}


class ThreadExample extends Thread {
    @Override
    public void run() {
        for (int x = 0; x<10; x++){
            System.out.println("Running Thread " + x);
        }
    }
}

class RunnableExample implements Runnable{

    @Override
    public void run() {
        for (int x = 0; x<10; x++){
            System.out.println("Running Runnable " + x);
        }
    }
}
