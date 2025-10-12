package Examples;

import java.util.Arrays;


public class Example6ConvertIntArrayToList {

    public static void main(String[] args) {


        Arrays.stream(new int []{1,2,3,4,5,6,7,8,9,10,11})
                .boxed()// CONVERT STREAM OF PRIMITIVES TO STREAM OF WRAPPER CLASSES
                .forEach(System.out::println); // REMEMBER HOW TO DO METHOD REFERENCE FOR SYS.OUT


    }

}
