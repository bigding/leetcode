/*******
    ***created by bigding at 2017年06月27日 星期二 23时22分11秒
    ***introduce:
 *******/

public class UniquePaths_62{
    public static int uniquePaths(int m, int n){
        int[][] tip = new int[m+1][n+1];
        for(int i = 0; i < m+1;i++){
            for(int j = 0; j < n+1; j++){
                tip[i][j] = -1;
            }
        }
        return f(1,1,m,n,tip);
    }
    public static int f(int i, int j, int m, int n,int[][] tip){
        if(i == m && j == n){
            return 1;
        }
        if(tip[i][j] != -1){
            return tip[i][j];
        }
        else if(i == m && j < n){
            tip[i][j] = f(i,j+1,m,n,tip);
        }
        else if(i < m && j == n){
            tip[i][j] = f(i+1, j,m,n,tip);
        }
        else{
            tip[i][j] = f(i+1,j,m,n,tip) + f(i,j+1,m,n,tip);
        }
        return tip[i][j];
    }
}
