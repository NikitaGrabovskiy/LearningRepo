package Examples;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Example40SelectionSearch {

    public static void main(String[] args) {

        int [] randomNumbers = Stream.generate(()-> {
            Random random = new Random();
            return random.nextInt(100);})
                .limit(100)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(selectionSort(randomNumbers)));
    }

    private static int[] selectionSort(int [] numbers){


        int lastUnsortedIndex = numbers.length;
        OUTER : for(int outer = 0; outer < numbers.length; outer++){



            int maxValue = 0;
            int indexOfMaxValue = 0;

            for(int inner = 0; inner < lastUnsortedIndex; inner++){

                if(numbers[inner]>maxValue){
                     maxValue = numbers[inner];
                     indexOfMaxValue = inner;
                 }

                 if(inner==lastUnsortedIndex-1){
                        numbers[indexOfMaxValue]=numbers[lastUnsortedIndex-1];
                        numbers[lastUnsortedIndex-1]=maxValue;
                        lastUnsortedIndex--;
                        if(lastUnsortedIndex<=1){
                             break OUTER;
                        }
            }
            }
        }

        return numbers;
    }












}
