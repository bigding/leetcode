/*******
    ***created by bigding at 2017年06月29日 星期四 20时55分04秒
    ***introduce:
 *******/

public class BestTimeToBuyAndSellStockWithCooldown_309{
    public static int maxProfit(int[] prices){
        if(prices.length < 2){
            return 0;
        }
        int[] tip = new int[prices.length+1];
        for(int i = 0; i < tip.length; i++){
            tip[i] = -1;
        }
        return f(0, prices,tip);
    }
    public static int f(int n, int[] arr, int[] tip){
        //System.out.println(n);
        if(n >= arr.length-1){
            return 0;
        }
        if(tip[n] == -1){
            int tipValue = 0;
            int min = arr[n];
            for(int j = n; j < arr.length; j++){
                if(arr[j] > min){
                    tipValue = Math.max(tipValue, arr[j] - min + f(j + 2, arr,tip));
                }
                if(arr[j] < min){
                    min = arr[j];
                }
            }
            tip[n] = tipValue;
        }
        return tip[n];
    }
    public static void main(String[] args){
        int[] arr = {1,2,7,0,2};
        System.out.println(maxProfit(arr));
    }
}
