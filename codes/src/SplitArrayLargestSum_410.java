import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int m) {
        int[][] tip = new int[nums.length + 1][m + 1];
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sumArr[i] = sumArr[i -1]+nums[i];
        }
        System.out.println(Arrays.toString(sumArr));
        for (int p = nums.length - 1; p >= 0; p--) {
            for (int n = 1; n <= m; n++) {
                if (n == 1) {
                    int sum = 0;
                    for (int k = p; k < nums.length; k++) {
                        sum += nums[k];
                    }
                    tip[p][n] = sum;
                }
                else{
                    int minMax = Integer.MAX_VALUE;
                    for(int k = p+1; k < nums.length; k++){
                        int sum = sumArr[k-1] - sumArr[p] + nums[p];
                        int max = Math.max(sum,tip[k][n-1]);
                        if(max < minMax)
                            minMax = max;
                    }
                    tip[p][n] = minMax;
                }
            }
        }
        for(int[] inner:tip)
            System.out.println(Arrays.toString(inner));
        return tip[0][m];
    }

    public static void main(String[] args) {
        SplitArrayLargestSum_410 obj = new SplitArrayLargestSum_410();
        System.out.println(obj.splitArray(new int[]{7,2,5,10,8,2,5,10,8,2,5,10,8,2,5,10,8,2,5,10,8,2,5,10,8},3));
    }
}
