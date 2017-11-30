import java.util.Arrays;

public class GuessNumberHigherOrLower2_375 {
    int[][] tip;
    public int getMoneyAmount(int n) {
        tip = new int[n+1][n+1];
        for(int[] inner: tip)
            Arrays.fill(inner,-1);
        return findAmount(1,n);
    }
    public int findAmount(int m, int n){
        if(tip[m][n] == -1){
            if(m >= n) return 0;
            int min = Integer.MAX_VALUE;
            for(int i = m; i <= n; i++){
                min = Math.min(Math.max(findAmount(m,i-1),findAmount(i+1,n))+i,min);
            }
            tip[m][n] = min;
        }
        return tip[m][n];
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower2_375 obj = new GuessNumberHigherOrLower2_375();
        System.out.println(obj.getMoneyAmount(10));
    }
}
