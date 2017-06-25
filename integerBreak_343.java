/*******
    ***created by bigding at 2017年06月25日 星期日 16时56分05秒
    ***introduce:
 *******/
import java.util.*;

public class integerBreak_343{
    public static int integerBreak(int n){
        int[] arr = new int[n + 1];
        int value = f(n,arr);
       // for(int i = 0; i <= n;i++){
       //     System.out.println(i+":\t"+arr[i]);
       // }
        return value;
    }
    public static int f(int x,int[] arr){
        if(x == 1){
            return 1;
        }
        else if(x == 2){
            return 1;
        }
        else if(x == 3){
            return 2;
        }
        else{
            if(arr[x] != 0){
                return arr[x];
            }
            int maxValue = 0;
            for(int i = 1; i <= x/2; i++){
                maxValue = Math.max(f(i,arr)*f(x-i,arr),maxValue);
                maxValue = Math.max(i*f(x-i,arr),maxValue);
                maxValue = Math.max(f(i,arr)*(x-i),maxValue);
                maxValue = Math.max(i*(x-i),maxValue);
            }
            arr[x] = maxValue;
            return maxValue;
        }
    }
    public static void main(String[] args){
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        System.out.println(integerBreak(num));
    }
}
