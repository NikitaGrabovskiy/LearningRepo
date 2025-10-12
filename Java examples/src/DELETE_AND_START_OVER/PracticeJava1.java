package DELETE_AND_START_OVER;

public class PracticeJava1 {



    public static void main (String... args){
//        Thread myThread = new MyThread();
//        myThread.start();
//
//        Thread secondThread = new Thread(new RunnableImplementation());
//        secondThread.start();

        Thread thread = new MyThread(new Runnable(()-> {
            return System.out.println("Thread run");
        }));
    }


    static class MyThread extends Thread {

        @Override
        public void run(){
            for(int i =0; i<1000; i++){
                System.out.println("Running thread " + i);
            }
        }
    }

    static class RunnableImplementation implements Runnable{

        @Override
        public void run(){
            for(int i =0; i<1000; i++){
                System.out.println("Runnable thread " + i);
            }
        }
    }



}
