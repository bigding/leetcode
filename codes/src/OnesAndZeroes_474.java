import java.util.Arrays;

public class OnesAndZeroes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0')
                    arr[i][0]++;
                else
                    arr[i][1]++;
            }
        }
        for(int[] inner: arr){
            System.out.println(Arrays.toString(inner));
        }
        System.out.println();
        int[][][] tip = new int[strs.length+1][m+1][n+1];
        for(int a = strs.length-1; a >=0; a--){
            for(int i = 0; i <= m; i++){
                for(int j = 0; j <= n; j++){
                    if(i - arr[a][0] < 0 || j - arr[a][1] < 0) {
                        tip[a][i][j] = tip[a+1][i][j];
                        continue;
                    }
                    tip[a][i][j] = Math.max(tip[a+1][i][j],tip[a+1][i-arr[a][0]][j-arr[a][1]]+1);
                }
            }
        }
        for(int outer[][]: tip){
            for(int[] inner: outer)
                System.out.println(Arrays.toString(inner));
            System.out.println();
        }
        return tip[0][m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes_474 obj = new OnesAndZeroes_474();
        System.out.println(obj.findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
    }
}
