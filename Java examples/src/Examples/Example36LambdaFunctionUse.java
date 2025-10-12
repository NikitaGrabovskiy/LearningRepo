package Examples;

import java.util.stream.IntStream;

public class Example36LambdaFunctionUse {


    public static void main (String [] arg){

        IntStream.range(1,10).boxed().forEach(System.out::println);

    }



}
