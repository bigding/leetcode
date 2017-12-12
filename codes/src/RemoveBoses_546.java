public class RemoveBoses_546 {

    /**
     * f(i,j,k)=Max(f(i+1,j,1)+k*k, f(i+1,m-1,1)+f(m,j,k+1))   box[i] = box[m]
     * emmm  有点难度
     */
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        dp = new int[boxes.length + 1][boxes.length + 1][boxes.length + 1];
        return findNum(boxes, 0, boxes.length - 1, 1);
    }

    public int findNum(int[] boxes, int i, int j, int k) {
        if (i > j)
            return 0;
        if (i == j)
            return k * k;
        if (dp[i][j][k] != 0)
            return dp[i][j][k];
        else {
            int max = findNum(boxes, i + 1, j, 1) + k * k;
            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m])
                    max = Math.max(max, findNum(boxes, i + 1, m - 1, 1) + findNum(boxes, m, j, k + 1));
            }
            dp[i][j][k] = max;
            return max;
        }
    }

    public static void main(String[] args) {
        RemoveBoses_546 obj = new RemoveBoses_546();
        System.out.println(obj.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }
}
