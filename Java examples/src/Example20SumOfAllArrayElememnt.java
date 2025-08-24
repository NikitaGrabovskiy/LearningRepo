import java.util.Arrays;
import java.util.OptionalInt;

public class Example20SumOfAllArrayElememnt {

    public static void main(String[] args) throws InterruptedException {
        int [] array = new int[]{0,0,1};
        sumOfAllArrays(array);
    }

    private static int sumOfAllArrays(int [] array){
        OptionalInt optionalInt = Arrays.stream(array).reduce((a, b )-> a+b);
        int result = optionalInt.isPresent()?optionalInt.getAsInt():0;
        System.out.println("Result of combining all integers from array is " + result);
        return result;
    }

}
