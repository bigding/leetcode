/*******
    ***created by bigding at 2017年06月29日 星期四 21时55分30秒
    ***introduce:
 *******/

public class ClimbintStairs_70{
    public static int climbStairs(int n){
        int[] tip = new int[n+1];
        for(int i = 0; i < tip.length; i++){
            tip[i] = -1;
        }
        return f(n,tip);
    }
    public static int f(int n, int[] tip){
        if(n <= 1){
            return 1;
        }
        if(tip[n] == -1){
            tip[n] = f(n - 1, tip) + f(n - 2, tip);
        }
        return tip[n];
    }
}
