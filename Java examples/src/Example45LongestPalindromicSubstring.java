/*
Longest Palindromic Substring
        Medium
        Topics
        premium lock icon
        Companies
        Hint
        Given a string s, return the longest palindromic substring in s.



        Example 1:

        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.
        Example 2:

        Input: s = "cbbd"
        Output: "bb"


        Constraints:

        1 <= s.length <= 1000
        s consist of only digits and English letters.*/


import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.*;

public class Example45LongestPalindromicSubstring {

    public static void main(String [] args){
        System.out.println(findLongestPalindromicSubstring("cbbd"));
    }

    private static String findLongestPalindromicSubstring(String text){

        text = text.toLowerCase();

        String longestPalindromicSubstring = "";

        for(int outer = 0; outer<text.length(); outer++){

            if(text.length()-outer<=longestPalindromicSubstring.length()){
                break;
            }

            for(int inner = outer; inner< text.length(); inner++){

                String substring = text.substring(outer,inner+1);
                if(substring.equals(new StringBuilder(substring).reverse().toString())
                        && substring.length() > longestPalindromicSubstring.length()){
                    longestPalindromicSubstring = substring;
                }

            }
        }

        return longestPalindromicSubstring;
    }




}
