import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Example42QuickSort {

    public static void main(String[] args) {
        int [] randomNumbers = Stream.generate(() -> {Random random = new Random();
        return random.nextInt(101);})
                .limit(100)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("Before sorting: "+ Arrays.toString(randomNumbers));

        quickSort(randomNumbers,0, randomNumbers.length-1);

        System.out.println("After sorting "+Arrays.toString(randomNumbers));
    }


    private static void quickSort(int [] array,int left, int right){
        if(left>right) return;
        int pi = partition (array,left,right);
        quickSort(array,pi+1,right);
        quickSort(array, left, pi-1);
    }

    private static int partition(int[] array, int left, int right) {

        int pi = array[right];
        int i = left;

        for(int j = left; j<right; j++){
            if(array[j]<pi){
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
            }
        }

        int temp = array[i];
        array[i]=array[right];
        array[right]=temp;
        return i;
    }

}
