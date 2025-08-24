import java.util.Arrays;
import java.util.Random;

public class Example22ShuffleArray {

    public static void main(String[] args) throws InterruptedException {

        int [] array = new int[] {1,2,3,4,5,6,7,8,9,10};

        int [] shuffledArray = shuffleArray(array);
        System.out.println(Arrays.toString(shuffledArray));
        Arrays.sort(shuffledArray);
        System.out.println(Arrays.toString(shuffledArray));


    }

    private static int [] shuffleArray(int [] numbers){

        if(numbers == null || numbers.length<=1){
            return numbers;
        }

        Random random = new Random();
        int [] shuffledArray = new int[numbers.length];

        int defaultValue = Arrays.stream(numbers).max().getAsInt() + 1;

        for(int index = 0; index<shuffledArray.length;index++){
            while(shuffledArray[index]!=defaultValue){
                int randomIndex = random.nextInt(10);
                if(numbers[randomIndex]!=defaultValue){
                    shuffledArray[index]=numbers[randomIndex];
                    numbers[randomIndex]=defaultValue;
                    break;
                }
            }
        }

        return shuffledArray;
    }
}
