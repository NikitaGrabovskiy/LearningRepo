import TestClasses.TestInterface;

import java.util.ArrayList;
import java.util.List;



public class Example35TestInterface {

    public static void main(String[] args) throws InterruptedException {

        List<String> words = new ArrayList<>();
        words.add("test");

        // Functional interface in a different file
        TestInterface testInterface = a -> a.toUpperCase();
        words.stream().map(testInterface::format).forEach(System.out::println);

    }









}