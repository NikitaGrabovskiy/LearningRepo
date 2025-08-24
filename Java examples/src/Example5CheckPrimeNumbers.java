
import java.util.Arrays;


public class Example5CheckPrimeNumbers {

    public static void main(String[] args) {

        Arrays.stream(new int []{1,2,3,4,5,6,7,8,9,10,11})
                .boxed()// CONVERT STREAM OF PRIMITIVES TO STREAM OF WRAPPER CLASSES
                .forEach( integer -> {checkPrimeNumber(integer);});

    }

    private static void checkPrimeNumber(int numberToCheck){

        if(numberToCheck <=3 && numberToCheck >=0){
            printPrimeNumber(numberToCheck);
            return;
        }

        for(int a = 2; a < numberToCheck; a++ ){

            if(numberToCheck%a == 0){
                System.out.println("Number "+numberToCheck+" is not prime , it can be devided by " + a);
                return;
            }
        }

        printPrimeNumber(numberToCheck);
    }

    private static void printPrimeNumber(int numberToCheck){
        System.out.println("Number "+ numberToCheck+" is prime");
    }


}
