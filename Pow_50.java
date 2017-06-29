/*******
    ***created by bigding at 2017年06月26日 星期一 09时11分44秒
    ***introduce:
 *******/

public class Pow_50{
    public static double myPow(double x, int n){
        if(x > 1 && n == -2147483648){
            return 0.0;
        }
        double ans = 1;
        double num = x;
        int number = Math.abs(n);
        System.out.println(number);
        while(number > 0){
            System.out.println(number);
            int tmp = number % 2;
            if(tmp == 1){
                ans *= num;
            }
            num *= num;
            number /= 2;
        }
        if(n<0){
            return 1/ans;
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(myPow(2,-2147483648));
    }
}
