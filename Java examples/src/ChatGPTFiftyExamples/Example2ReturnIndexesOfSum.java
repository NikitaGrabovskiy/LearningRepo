package ChatGPTFiftyExamples;

public class Example2ReturnIndexesOfSum {


    public static void main(String[] args){

        int [] result = returnIndexes(new int[] {1,2,3,4,5,6}, 7);
        System.out.println("First index is " + result[0] + " second index is "+ result[1]);
    }


    private static int [] returnIndexes(int [] numbers, int sum){

        for(int a = 0; a < numbers.length; a++ ){
            for(int innerIndex = 0; innerIndex < numbers.length; innerIndex++ ){
            if(a == innerIndex){
                continue;
            }
                if (sum == numbers[a]+numbers[innerIndex]) {
                    return new int[] {a,innerIndex};
                }
            }
        }

        System.out.println("None of two element combined equals to sum number");
        return null;
    }

}
