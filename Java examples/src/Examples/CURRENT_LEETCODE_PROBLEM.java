package Examples;

public class CURRENT_LEETCODE_PROBLEM {

    public static void main(String[] args) {

        int [] test = new int[]{3,2,1,0,4};

        System.out.println(canJump(test));
    }

    public static boolean canJump(int[] nums) {

        int maxReach = 0;

        for(int x = 0; x<nums.length; x++){

            if(x>maxReach){
                return false;
            }

            int currentJumpLength = nums[x] + x;
            if(currentJumpLength>maxReach){
                maxReach=currentJumpLength;
            }

        }

        return true;
    }

}
