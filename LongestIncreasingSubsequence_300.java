/*******
    ***created by bigding at 2017年06月30日 星期五 22时30分56秒
    ***introduce:
 *******/

public class LongestIncreasingSubsequence_300{
    public static int lengthOfLIS(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int[] tip = new int[nums.length];
        for(int i = 0; i < tip.length; i++){
            tip[i] = -1;
        }
        return f(0, nums, tip);
    }
    public static int f(int m, int[] nums, int[] tip){
        if(m == nums.length - 1){
            return 1;
        }
        else if(tip[m] == -1){
            int maxValue = 1;
            if(m == 0){
                for(int i = m; i < nums.length; i++){
                    int j;
                    for(j = i+1; j < nums.length; j++){
                        if(nums[i] < nums[j]){
                            maxValue = Math.max(maxValue,1 + f(j, nums, tip));
                        }
                    }
                }
            }
            else{
                for(int j = m+1; j < nums.length; j++){
                    if(nums[m] < nums[j]){
                        maxValue = Math.max(maxValue,1 + f(j, nums, tip));
                    }
                }
            }
            tip[m] = maxValue;
        }
        return tip[m];
    }
    public static void main(String[] args){
        int[] nums = {4,10,4,8};
        System.out.println(lengthOfLIS(nums));
    }
}
