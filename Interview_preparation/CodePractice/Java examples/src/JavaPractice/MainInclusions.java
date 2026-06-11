package JavaPractice;

import java.util.Arrays;

public class MainInclusions {

    public static void main(String [] args){

        System.out.println(checkInclusion("abc","ffererabtc"));
    }


    private static boolean checkInclusion(String a, String b){

        int[] aCount = new int[26];
        int[] permutation =  new int[26];

        for(char c : a.toCharArray()){
            aCount[c - 'a']++;
        }

        for(int i = 0; i<a.length(); i++){
            permutation[b.charAt(i) - 'a']++;
        }

        int left = 0;

        for(int right = a.length(); right<b.length();right++){

            if(Arrays.equals(aCount,permutation)){
                return true;
            }

            permutation[b.charAt(right) - 'a']++;
            permutation[b.charAt(left) - 'a']--;
            left++;
        }

        return false;
    }
}
