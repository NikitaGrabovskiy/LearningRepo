import java.util.Arrays;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Example1ReverseString {
    public static void main(String[] args) {

        String testString = "reverseString";
        StringBuilder stringBuilder = new StringBuilder(testString);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}