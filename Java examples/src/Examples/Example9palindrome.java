package Examples;

import java.util.List;
import java.util.Optional;

public class Example9palindrome {

    public static void main(String[] args) {

        String word = "Mom";

        if(checkIfStringIsPalindrome(word)){
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }

    private static boolean checkIfStringIsPalindrome(String word){
        StringBuilder stringBuilder = new StringBuilder(word);
        StringBuilder reverseWord = stringBuilder.reverse();
        return word.equalsIgnoreCase(reverseWord.toString())? true: false;
    }



}
