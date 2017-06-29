/*******
    ***created by bigding at 2017年06月26日 星期一 19时14分09秒
    ***introduce:
 *******/

public class LongestPaliadromicSubsequence_516{
    public static int longestPaliadromicSubseq(String s){
        int[][] tip = new int[s.length()][s.length()];
        for(int[] outer:tip){
            for(int inner:outer)
                inner = 0;
        }
        return f(0, s.length() - 1, s, tip);
    }
    public static int f(int m, int n, String s, int[][] tip){
        if(m > n){
            return 0;
        }
        if(m == n){
            return 1;
        }
        if(tip[m][n] != 0){
            return tip[m][n];
        }
        int maxNum = 0;
        if(s.charAt(m) == s.charAt(n)){
            maxNum = 2 + f(m+1, n-1,s, tip);
        }
        else{
            maxNum = Math.max(f(m+1,n,s,tip),f(m,n-1,s,tip));
        }
        tip[m][n] = maxNum;
        return maxNum;
    }
    public static void main(String[] args){
        System.out.println(longestPaliadromicSubseq("bbabb"));
    }
}
