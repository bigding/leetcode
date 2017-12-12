import java.util.Arrays;

public class HouseRobber2_213 {
    public int rob(int[] nums){
        int max1 = 0, max2 = 0;
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length+2];
        for(int i = nums.length-1; i > 0; i--){
            dp[i] = Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        max1 = dp[1];
        Arrays.fill(dp,0);
        for(int i = nums.length -2; i >= 0; i--){
            dp[i] = Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        max2 = dp[0];
        return Math.max(max1,max2);
    }
}
