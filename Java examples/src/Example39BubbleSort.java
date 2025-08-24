import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Example39BubbleSort {


    public static void main(String[] args) {

        int [] testArrays = generateArrayOfRandomNumbersUsingStreams(100);
        System.out.println(Arrays.toString(testArrays));

        System.out.println(Arrays.toString(bubbleSort(testArrays)));
    }

    private static int [] bubbleSort(int [] numbers){

        int lastIndex = numbers.length-1;
        Outer : for(int outer = 0; outer < numbers.length-1; outer++){
            for(int inner = 0; inner < lastIndex; inner++){

            if(numbers[inner]>numbers[inner+1]){
                int largerNumber = numbers[inner];
                int smallerNumber = numbers[inner+1];
                numbers[inner] = smallerNumber;
                numbers[inner+1] = largerNumber;
            }
            }
            lastIndex--;
            if(lastIndex<=0){
                break Outer;
            }
        }
        return numbers;
    }

    private static int [] generateArrayOfRandomNumbers(int length){
        int [] randomNumbers = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++){
            randomNumbers[i] = random.nextInt(length);
        }
        return randomNumbers;
    }

    private static int [] generateArrayOfRandomNumbersUsingStreams(int length) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(length+1))
                .limit(100)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
