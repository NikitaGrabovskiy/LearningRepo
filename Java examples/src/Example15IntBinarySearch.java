import java.util.Arrays;

public class Example15IntBinarySearch {

    public static void main(String[] args) throws InterruptedException {

        // Make one more for Strings

        int[] numbers = new int[]{2,4,7,8,11,44,88,109};

        findIntWithBinarySearchFromArray(numbers, 88,true,0);


    }

    public static int findIntWithBinarySearchFromArray(int [] numbers, int numberToFind, boolean enableLogs, int arrayIndex){

        if(numbers.length<=1 && numbers[0] != numberToFind){
            System.out.println("Number not present");
            return -1;
        }

        int index = numbers.length/2;
        if(numbers[index] == numberToFind){
            printLog("Found number " + numberToFind,enableLogs);
            return numbers[index];
        } else if(numbers[index] > numberToFind){
            return findIntWithBinarySearchFromArray(Arrays.copyOfRange(numbers,0,index), numberToFind, enableLogs,arrayIndex);
        } else {
            return findIntWithBinarySearchFromArray(Arrays.copyOfRange(numbers,index,numbers.length), numberToFind, enableLogs,arrayIndex);
        }
    }

    private static void printLog(String text, boolean print){
        if(print){
            System.out.println(text);
        }
    }

}
