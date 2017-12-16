public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] tip = new int[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    tip[i][j] = 1;
                }
                if(grid[i][j] == 1 && tip[i][j] == 0){
                    maxArea = Math.max(maxArea,searchIsland(i, j,  grid, tip));
                }
            }
        }
        return maxArea;
    }
    int searchIsland(int i, int j, int[][] grid, int[][] tip){
        if(i < 0 || j < 0|| i >= grid.length || j >= grid[0].length||
                grid[i][j] == 0 || tip[i][j] == 1)
            return 0;
        tip[i][j] = 1;
        return 1+
                searchIsland(i+1,j,grid,tip)+
                searchIsland(i-1,j,grid,tip)+
                searchIsland(i,j+1,grid,tip)+
                searchIsland(i,j-1,grid,tip);
    }
}
