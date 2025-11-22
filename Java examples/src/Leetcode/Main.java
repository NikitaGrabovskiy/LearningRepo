package Leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(trailingZeroes(13));
    }


    public static int trailingZeroes(int n) {

        String factorial = String.valueOf(calculateFactorial(n));

        System.out.println(factorial);

        int countOfTrailingZeroes = 0;
        for(int i = factorial.length()-1; i>=0;i--){
            char digit = factorial.charAt(i);
            if(digit != '0'){break;}
            countOfTrailingZeroes++;
        }
        return countOfTrailingZeroes;
    }

    private static long calculateFactorial(int n){

        long result = 1;
        for(long i = 1; i<=n; i++){
            System.out.println("Multiply by"+i);
            result*=i;
        }
        return result;
    }
}
