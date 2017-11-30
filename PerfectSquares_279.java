import java.util.Arrays;

public class PerfectSquares_279 {
    int[] tip;
    public int numSquares(int n){
        tip = new int[n + 1];
        Arrays.fill(tip, 0);
        return findNum(n);
    }
    public int findNum(int n){
        if(tip[n] == 0){
            if(n == 0)
                return 0;
            int num = Integer.MAX_VALUE;
            if(n == 1 || n == 4 || n == 9 || n == 16 || n == 25)
                return 1;
            for(int i = 1; i*i <= n; i++){
                num = Math.min(findNum(n - i * i) + 1,num);
            }
            tip[n] = num;
        }
        return tip[n];
    }

    public static void main(String[] args) {
        PerfectSquares_279 obj = new PerfectSquares_279();
        System.out.println(obj.numSquares(13));
    }
}
