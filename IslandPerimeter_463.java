/*******
    ***created by bigding at 2017年05月03日 星期三 11时30分46秒
    ***introduce:求面积
 *******/

public class IslandPerimeter_463{
    public static int islandPerimeter_463ndPerimeter(int[][] grid){
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || grid[i-1][j] == 0)
                        num++;
                    if(i == grid.length -1 || grid[i+1][j] == 0)
                        num++;
                    if(j == 0 || grid[i][j-1] == 0)
                        num++;
                    if(j == grid[0].length-1 || grid[i][j+1] == 0)
                        num++;
                }
            }
        }
        return num;
    }
}

