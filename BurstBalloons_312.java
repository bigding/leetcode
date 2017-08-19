/*******
    ***created by bigding at 2017年06月30日 星期五 21时05分04秒
    ***introduce:
 *******/
public class BurstBalloons_312{
    public int maxCoins(int[] nums){
        int[][] tip = new int[nums.length+2][nums.length+2];
        for(int i = 0; i < tip.length; i++){
            for(int j = 0; j < tip[0].length; j++){
                tip[i][j] = -1;
            }
        }
        int[] tmp = new int[nums.length + 2];
        for(int i = 1; i < tmp.length-1; i++){
            tmp[i] = nums[i-1];
        }
        tmp[0] = tmp[tmp.length-1] = 1;
        return f(0, nums.length + 1, tmp, tip);
}
int f(int m, int n, int[] nums, int[][] tip){
        if(n - m == 1){
            return 0;
        }
        if(tip[m][n] == -1){
            int value = 0;
            for(int i = m + 1; i < n; i++){
                value = Math.max(value, nums[m]*nums[i]*nums[n]+f(m,i,nums,tip)+f(i,n,nums,tip));
            }
            tip[m][n] = value;
        }
        return tip[m][n];
    }
}
