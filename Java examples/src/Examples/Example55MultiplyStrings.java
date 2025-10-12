package Examples;/*

3. Multiply Strings
        Medium
        Topics
        premium lock icon
        Companies
        Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

        Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



        Example 1:

        Input: num1 = "2", num2 = "3"
        Output: "6"
        Example 2:

        Input: num1 = "123", num2 = "456"
        Output: "56088"


        Constraints:

        1 <= num1.length, num2.length <= 200
        num1 and num2 consist of digits only.
        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/


public class Example55MultiplyStrings {
    public static void main(String[] args) {

        System.out.println(multiply("498828660196","840477629533"));
        //System.out.println(convertStringToLong("6913259244"));
    }

    public static String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int firstNumberLength = num1.length();
        int secondNumberLength = num2.length();


        int [] resultAsArray = new int[firstNumberLength+secondNumberLength];

        for(int i = firstNumberLength - 1; i >=0; i--){
            int d1 = num1.charAt(i) - '0';
            for(int j = secondNumberLength - 1; j >=0; j --){

                int d2 = num2.charAt(j) - '0';
                int mul = d1*d2 +resultAsArray[i+j+1];

                resultAsArray [i+j+1]=mul%10;
                resultAsArray [i +j] += mul/10;
            }
        }


        StringBuilder stringBuilder = new StringBuilder(resultAsArray.length);
        int k = 0;
        while (k < resultAsArray.length && resultAsArray[k]== 0) k++;
        for(;k<resultAsArray.length; k++) stringBuilder.append(resultAsArray[k]);
        return stringBuilder.toString();
    }













}
