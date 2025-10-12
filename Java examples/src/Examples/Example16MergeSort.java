package Examples;

import java.util.Arrays;
import java.util.Random;

public class Example16MergeSort {

    public static void main(String[] args) throws InterruptedException {

        int [] numbers = createArrayOfRandomInts(10,100);
        System.out.println(Arrays.toString(numbers));

        printLog("Before sort ",numbers);

        int [] sortedArray = mergeSort(numbers,0,numbers.length-1);

        printLog("Sorted array ",sortedArray);


    }

    private static int [] mergeSort(int [] numbers, int low, int high){



        if(low == high){
            int [] array = new int[1];
            array [0] = numbers[low];
            return array;
        }

        int middle = (low+high)/2;

        int [] first = mergeSort(numbers,low,middle);
        int [] second = mergeSort(numbers,middle + 1, high);

        return mergeTwoArrays(first,second);
    }



    private static int[] mergeTwoArrays (int [] first, int [] second){

        printLog("Merge first",first);
        printLog("Merge second",second);


        int [] mergedArray = new int[first.length+second.length];

        int firstArrayIterator = 0;
        int secondArrayIterator = 0;
        int mergedArrayIterator = 0;

        while (firstArrayIterator < first.length && secondArrayIterator < second.length){
            if(first[firstArrayIterator] < second[secondArrayIterator]){
                mergedArray[mergedArrayIterator]=first[firstArrayIterator];
                mergedArrayIterator++;
                firstArrayIterator++;
            } else {
                mergedArray[mergedArrayIterator]=second[secondArrayIterator];
                mergedArrayIterator++;
                secondArrayIterator++;
            }
        }

      //  printLog("Merged array",mergedArray);

        if(firstArrayIterator == first.length){
            while(secondArrayIterator<second.length){
                System.out.println("Adding "+ second[secondArrayIterator]);
                mergedArray[mergedArrayIterator]=second[secondArrayIterator];
                mergedArrayIterator++;
                secondArrayIterator++;
            }
        }

        if(secondArrayIterator == second.length){
            while (firstArrayIterator<first.length){
                //System.out.println("Adding "+first[firstArrayIterator]);
                mergedArray[mergedArrayIterator]=first[firstArrayIterator];
                mergedArrayIterator++;
                firstArrayIterator++;
            }
        }

        printLog("Merged result",mergedArray);

        return mergedArray;

    }






    private static void printLog(String message,int [] numbers){
        System.out.println(message+Arrays.toString(numbers));
    }


    private static int [] createArrayOfRandomInts(int length, int randomBound){
        Random random = new Random();
        int [] numbers = new int[length];
        for(int a = 0; a < length; a++){
            numbers[a] = random.nextInt(randomBound);
        }
        return numbers;
    }

}
