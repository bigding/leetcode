/*******
    ***created by bigding at 2017年06月29日 星期四 22时15分36秒
    ***introduce:
 *******/
public class MaximumSubarray_53{
/*此动态规划法,对于数据量大的测试用例会超时,看别人的讨论看到了更优美的解法,放在下面
    public static int maxSubArray(int[] nums){
        int[][] tip = new int[nums.length +1][nums.length+1];
        for(int i = 0; i < tip.length; i++){
            for(int j = 0; j < tip[0].length; j++){
                tip[i][j] = Integer.MIN_VALUE;
            }
        }
        return f(0,nums.length, nums, tip);
    }
    public static int f(int m, int n, int[] nums, int[][] tip){
        if( m >= n ){
            return Integer.MIN_VALUE;
        }
        if(n - m == 1){
            return nums[m];
        }
        if(tip[m][n] == Integer.MIN_VALUE){
            int max = Integer.MIN_VALUE;
            for(int i = m; i < n ; i++){
                for(int j = i+1; j <= n; j++){
                    if(i == m && j == n){
                        int tmp = 0;
                        for(int h = m; h < n; h++){
                            tmp += nums[h];
                        }
                        max = Math.max(max,tmp);
                        continue;
                    }
                    //System.out.println(i+"\t"+j);
                    max = Math.max(f(m,i,nums,tip),max);
                    max = Math.max(f(i,j,nums,tip),max);
                    max = Math.max(f(j,n,nums,tip),max);
                }
            }
            tip[m][n] = max;
        }
        return tip[m][n];
    }
    */
    //从前向后遍历一遍,如果前面积累的数值为正,以当前数值为和继续往下走.为负则重新开始
    public int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    public static void main(String[] args){
        int[] nums = {-2,-4};
        System.out.println(maxSubArray(nums));
    }
}
