import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    int[][] tip;
    public int splitArray(int[] nums, int m){
        tip = new int[nums.length+1][m];
        for(int[] inner: tip){
            Arrays.fill(inner, -1);
        }
        return findNum(nums, nums.length, m -1);
    }
    public  int findNum(int[] nums, int m, int n){
        if(tip[m][n]  == -1){
            if(m >= nums.length)
                return 0;
            int sum = 0;
            if( n == 0){
                while(m < nums.length)
                    sum += nums[m];
            }
            else{
                for(int k = m, m < )
            }
        }
        return tip[m][n];
    }
}
