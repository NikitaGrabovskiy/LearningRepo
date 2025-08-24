public class Example7FibonacciWithRecursion {

    public static void main(String[] args) {

        // Fibonacci sequence - The next number is sum of previous 2 numbers

        printFibonacciSequence();

    }

    private static void printFibonacciSequence(){
        System.out.println(0);
        System.out.println(1);
        getNextNumber(0,1,0,10);
    }


    private static void getNextNumber(int firstNumber, int secondNumber, int counter, int limit){

        int nextNumber = firstNumber+secondNumber;
        System.out.println(nextNumber);
        counter++;
        if(counter>=limit){
            return;
        }
        getNextNumber(secondNumber,nextNumber,counter,limit);
    }

}
