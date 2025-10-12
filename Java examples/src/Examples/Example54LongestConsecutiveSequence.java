package Examples;
/*
*
*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3

*
*
*
*
*
* */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example54LongestConsecutiveSequence {


    public static void main(String[] args) {

        int [] input = new int[]{0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(input));
    }

    public static int longestConsecutive(int[] nums) {

        Arrays.sort(nums);

        Map<Integer,Integer> values = new TreeMap<>();

        int longestConsecutive = 0;

        for(int i = 0; i< nums.length; i++){
            if(values.containsKey(Integer.valueOf(nums[i]))){
                continue;
            } else {

                Integer consecutiveForCurrentNumber = values.get(Integer.valueOf(nums[i]) - 1);

                if (consecutiveForCurrentNumber == null) {
                    values.put(nums[i], 1);
                    if(longestConsecutive==0){
                        longestConsecutive=1;
                    }
                } else {
                    int increaseValue = consecutiveForCurrentNumber.intValue() + 1;
                    if (increaseValue > longestConsecutive) {
                        longestConsecutive = increaseValue;
                    }
                    values.put(nums[i], increaseValue);
                }
            }
        }


        return longestConsecutive;

    }

}
