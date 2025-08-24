import java.util.stream.IntStream;

public class Example14Factorial {

    public static void main(String[] args) throws InterruptedException {

    int number = 36;

    System.out.println("Factorial of "+number+ " is " + calculateAFactorial(number));
    }

    private static int calculateAFactorial(int number){
        return IntStream
                .range(1,number+1)
                .reduce(1, (a, b) -> a * b); // IMPORTANT FUNCTION !!!
    }

}
