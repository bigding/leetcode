/*******
    ***created by bigding at 2017年06月25日 星期日 13时48分00秒
    ***introduce:
 *******/

public class PredictTheWinner_486{
    public static boolean PredictTheWinner(int[] nums){
        if(nums.length == 0){
            return false;
        }
        else if(nums.length == 1){
            return true;
        }
        int[][] tip = new int[nums.length][nums.length];
        for(int[] outer:tip){
            for(int inner:outer){
                inner = 0;
            }
        }
        int[] array = nums;
        int count = 0;
        for(int value:nums){
            count += value;
        }
        int number = f(0,nums.length-1, array,tip);
        return number >= (count - number);
    }
    static int f(int m, int n, int[] array, int[][] tip){
        if(m == n){
            return array[m];
        }
        if(Math.abs(m - n) == 1){
            return Math.max(array[m],array[n]);
        }
        else{
            if(tip[m][n] == 0){
                tip[m][n] = Math.max(f(m,m,array,tip)+Math.min(f(m+1,n-1,array,tip),f(m+2,n,array,tip)),f(n,n,array,tip)+Math.min(f(m+1,n-1,array,tip),f(m,n-2,array,tip)));
            }
            return tip[m][n];
        }
  }
}
