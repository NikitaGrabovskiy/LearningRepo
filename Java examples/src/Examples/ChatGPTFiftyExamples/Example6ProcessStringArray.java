package Examples.ChatGPTFiftyExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example6ProcessStringArray {

    public static void main(String[] args) {

        /*  Filters out any string with a length less than 4.
    Converts the remaining strings to uppercase.
    Sorts them alphabetically.
    Returns the resulting list.*/

        List<String> words = Arrays.asList("java", "is", "cool", "stream", "api", "rock","money","apple");

        List<String> result = words.stream().filter(a -> a.length() >= 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(result);

    }




}
