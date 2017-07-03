/*******
    ***created by bigding at 2017年06月30日 星期五 21时14分32秒
    ***introduce:
 *******/

public class MinimumPathSum_64{
    public static int minPathSum(int[][] grid){
        int[][] tip = new int[grid.length][grid[0].length];
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                tip[i][j] = -1;
            }
        }
        return f(0,0,grid, tip);
    }
    public static int f(int m, int n, int[][] grid, int[][] tip){
        if(m == grid.length - 1 && n == grid[0].length - 1){
            return grid[m][n];
        }
        if(tip[m][n] != -1){
            return tip[m][n];
        }
        if(m == grid.length - 1){
            tip[m][n] = grid[m][n] + f(m, n+1, grid, tip);
        }
        else if(n == grid[0].length - 1){
            tip[m][n] = grid[m][n] + f(m+1, n, grid, tip);
        }
        else{
            tip[m][n] = grid[m][n] + Math.min(f(m+1,n,grid,tip),f(m,n+1,grid,tip));
        }
        return tip[m][n];
    }
}
