/*******
    ***created by bigding at 2017年06月26日 星期一 15时24分46秒
    ***introduce:
 *******/

public class targetSum_494{
    public static int findTargetSumWays(int[] nums, int S){
        if(nums.length == 1){
            if(Math.abs(S) == Math.abs(nums[0]))
                return 1;
            else
                return 0;
        }
        return f(nums[0],1,nums,S)+f(-nums[0],1,nums,S);
    }
    public static int f(int value, int n, int[] arr, int s){
        if(n == arr.length - 1){
            int count = 0;
            if(value + arr[n] == s)
                count++;
            if(value - arr[n] == s)
                count++;
            return count;
        }
        else{
            return f(value + arr[n], n+1,arr,s)+f(value - arr[n],n+1,arr,s);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,1};
        int a = findTargetSumWays(arr,0);
        System.out.println(a);
    }
}
