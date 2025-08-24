import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Example41InsertionSort {

    public static void main(String[] args) {

        int [] randomIntegers = Stream.generate(()->{
            Random random = new Random();
            return random.nextInt(101);})
                .limit(100)
                .mapToInt(Integer::intValue).toArray();

        System.out.println("Before sort "+ Arrays.toString(randomIntegers));
        System.out.println("After sort  "+Arrays.toString(insertionSort(randomIntegers)));
    }



    private static int [] insertionSort(int [] values){

        for(int outer = 1; outer<values.length; outer++){
            int currentPosition = outer;
            int tempValue = values[currentPosition];
            while (true){
                if((currentPosition-1)>=0 && tempValue<values[currentPosition-1]){
                    values[currentPosition]=values[currentPosition-1];
                } else {
                    values[currentPosition]=tempValue;
                    break;
                }
                currentPosition--;

            }
        }

        return values;
    }
}
