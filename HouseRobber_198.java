/*******
    ***created by bigding at 2017年06月30日 星期五 21时47分47秒
    ***introduce:
 *******/

public class HouseRobber_198{
    public static int rob(int[] nums){
        int[] tip = new int[nums.length];
        for(int i = 0; i < tip.length; i++){
            tip[i] = -1;
        }
        return f(0, nums, tip);
    }
    public static int f(int n, int[] nums, int[] tip){
        if(n > nums.length - 1){
            return 0;
        }
        if(n == nums.length -1){
            return nums[n];
        }
        if(tip[n] != -1){
            return tip[n];
        }
        else{
            int max = 0;
            for(int i = n; i < nums.length; i++){
                max = Math.max(max, nums[i] + f(i + 2, nums, tip));
            }
            tip[n] = max;
        }
        return tip[n];
    }
}
