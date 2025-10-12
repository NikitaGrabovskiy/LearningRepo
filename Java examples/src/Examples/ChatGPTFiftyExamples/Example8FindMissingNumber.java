package Examples.ChatGPTFiftyExamples;

public class Example8FindMissingNumber {

    public static void main(String[] args) {

        System.out.println(findMissingNumber(new int[]{1, 2,3, 4, 6}));

    }



    private static int findMissingNumber(int [] numbers){

        for(int i = 0; i< numbers.length; i++){
            if(numbers[i]!=i+1){
                return i+1;
            }
        }

        return -1;
    }





}
