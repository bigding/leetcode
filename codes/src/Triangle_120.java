import java.util.*;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if(length == 1){
            return triangle.get(0).get(0);
        }
        int[] dp = new int[length+1];
        for(int m = length-1; m >= 0; m--){
            System.out.println(m);
            for(int n = 0; n <= m; n++){
                    dp[n] = Math.min(dp[n],dp[n+1])+triangle.get(m).get(n);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
}
