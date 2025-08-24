package ChatGPTFiftyExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example4Merge2DimensionalArrays {

   public static void main(String[] args) {

       int [][] testArray = new int [6][];

       testArray[0] = new int[]{1,10};
       testArray[1] = new int[]{10,21};
       testArray[2] = new int[]{3,10};
       testArray[3] = new int[]{30,34};
       testArray[4] = new int[]{35,36};
       testArray[5] = new int[]{2,3};

       testArray = bubbleSort(testArray);

       for (int [] a: testArray) {
           System.out.println(Arrays.toString(a));
       }

       System.out.println("__________________");

       testArray = merge(testArray);

       for (int [] a: testArray) {
           System.out.println(Arrays.toString(a));
       }



   }


   private static int [][] merge(int [][] indexes){
       bubbleSort(indexes);

       List<int []> result = new ArrayList<>();

       for(int i = 0; i < indexes.length; i++){
           if(i+1<indexes.length && indexes[i][1]>=indexes[i+1][0]){
               int [] mergedArray = new int[]{indexes[i][0],indexes[i+1][1]};
               indexes[i+1] = mergedArray;
           } else {
               result.add(indexes[i]);
           }
       }

        // Change later
       return result.toArray(new int[result.size()][]);
   }


    private static int [][] bubbleSort(int [][] arrayToSort){

        int sortedIndex = arrayToSort.length;

        for(int i = 0; i < arrayToSort.length; i++){

            if(sortedIndex == 0){
                break;
            }

            for(int innerIndex = 0; innerIndex < sortedIndex; innerIndex++){
                if(innerIndex+1<sortedIndex && arrayToSort[innerIndex][0] > arrayToSort[innerIndex+1][0]){

                    int [] secondValue = arrayToSort[innerIndex+1];
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
