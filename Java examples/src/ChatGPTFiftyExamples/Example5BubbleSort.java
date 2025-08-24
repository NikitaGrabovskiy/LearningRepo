package ChatGPTFiftyExamples;

import java.util.Arrays;

public class Example5BubbleSort {

    public static void main(String[] args) {

        int [] testArray = new int[]{2,6,5,4,3,1,8,9};

        bubbleSort(testArray);

        System.out.println(Arrays.toString(testArray));

    }


    private static int [] bubbleSort(int [] arrayToSort){

        int sortedIndex = arrayToSort.length;

        for(int i = 0; i < arrayToSort.length; i++){

            if(sortedIndex == 0){
                break;
            }

            for(int innerIndex = 0; innerIndex < sortedIndex; innerIndex++){
                if(innerIndex+1<sortedIndex && arrayToSort[innerIndex] > arrayToSort[innerIndex+1]){

                    int secondValue = arrayToSort[innerIndex+1];
                    arrayToSort[innerIndex+1] = arrayToSort[innerIndex];
                    arrayToSort[innerIndex] = secondValue;

                } else if (innerIndex+1>=sortedIndex){
                    sortedIndex--;
                }
            }

        }

        return arrayToSort;
    }
}
