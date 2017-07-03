/*******
    ***created by bigding at 2017年07月01日 星期六 21时55分35秒
    ***introduce:
 *******/

public class DistinctSubsequences_115{
    public int numDistinct(String s, String t){
        int[][] tip = new int[s.length()][t.length()];
        for(int i = 0; i < tip.length; i++){
            for(int j = 0; j < tip[0].length; j++){
                tip[i][j] = -1;
            }
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        return f(0,0,a,b,tip);
    }
    public int f(int m, int n, char[] s, char[] t, int[][] tip){
        if(n == t.length - 1){
            int value = 0;
            for(int i = m; i < s.length; i++){
                if(s[i] == t[n]){
                    value++;
                }
            }
            return value;
        }
        if(m >= s.length - 1){
            return 0;
        }
        if(tip[m][n] == -1){
            int max = 0;
            for(int j = m; j < s.length; j++){
                if(s[j] == t[n]){
                    max = max+f(j+1, n+1, s, t, tip);
                }
            }
            tip[m][n] = max;
        }
        return tip[m][n];
    }
}
