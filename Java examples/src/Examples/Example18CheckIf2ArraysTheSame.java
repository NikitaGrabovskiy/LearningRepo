package Examples;

import java.util.Arrays;

public class Example18CheckIf2ArraysTheSame {

    public static void main(String[] args) throws InterruptedException {

        int [] firstArray = new int[]{1,2,3,4};

        int [] secondArray = new int[]{2,1,4};

        int [] thirdArray = new int[]{2,33,4};

        System.out.println("Arrays are equal : " + arraysAreEqual(firstArray,secondArray));

    }

    private static boolean arraysAreEqual(int [] firstArray, int [] secondArray){
        if(firstArray.length != secondArray.length){
            System.out.println("Arrays have different number of elements");
            return false;
        }

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        for(int index = 0; index<firstArray.length; index++){
            if(firstArray[index]!=secondArray[index]){
                System.out.println("Arrays have different elements");
                return false;
            }
        }

        System.out.println("Arrays are equal");
        return true;
    }


}
