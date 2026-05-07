package JavaPractice;

import java.util.Arrays;

public class Main {

    public static void main(String [] args){
        System.out.println(Arrays.toString(rotateArray(new int[]{1,2,3,4,5,6,7},3)));
                                                              //{5,6,7,1,2,3,4}
    }

    public static int[] rotateArray(int [] array, int k){

        int n = array.length;
        k = k % n;

        reverse(array, 0, n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);

        return array;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
