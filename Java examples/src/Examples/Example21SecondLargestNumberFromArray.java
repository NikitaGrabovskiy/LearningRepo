package Examples;

import java.util.Arrays;

public class Example21SecondLargestNumberFromArray {

    public static void main(String[] args) throws InterruptedException {

        int [] array = new int[] {55,54};

        System.out.println("Second largest number from array is " + findSecondLargestNumberFromIntArray(array));

    }

    private static int findSecondLargestNumberFromIntArray(int [] numbers){

        int[] distinctValues = Arrays.stream(numbers).distinct().toArray();
        if(distinctValues.length<=1){
            throw new IllegalArgumentException("Array has only one or less distinct values");
        }

        Arrays.sort(distinctValues);
        return numbers[distinctValues.length-2];
    }

    
}
