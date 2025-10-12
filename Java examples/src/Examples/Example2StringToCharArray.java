package Examples;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Example2StringToCharArray {
    public static void main(String[] args) {

        String testString = "testString";
        List<Character> collect = testString.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());

        collect.forEach(out::println);
    }
}