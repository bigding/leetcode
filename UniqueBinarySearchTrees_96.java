/*******
    ***created by bigding at 2017年06月27日 星期二 22时54分56秒
    ***introduce:
 *******/

public class UniqueBinarySearchTrees_96{
    public static int numTrees(int n){
        int[] tip = new int[n + 1];
        for(int i = 0; i <= n; i++){
            tip[i] = -1;
        }
        return f(n,tip);
    }
    public static int f(int n, int[] tip){
        if(n <= 1)
            return 1;
        if(n == 2)
            return 2;
        else{
            if(tip[n] == -1){
                int num = 0;
                for(int i = 1; i <= n; i++){
                    num += f(i - 1, tip) * f(n - i, tip);
                }
                tip[n] = num;
            }
            return tip[n];
        }
    }
}
