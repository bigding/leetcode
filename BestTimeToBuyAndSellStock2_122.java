/*******
    ***created by bigding at 2017年07月09日 星期日 23时29分05秒
    ***introduce:
 *******/

public class BestTimeToBuyAndSellStock2_122{
    public int maxProfit(int[] prices){
        int length = prices.length;
        if(length < 2){
            return 0;
        }
        int count = 0,preMax = 0;
        for(int i = 1; i < length; i++){
            if(prices[i] < prices[i-1]){
                count += (prices[i-1] - prices[preMax]);
                preMax = i;
            }
        }
        if(prices[length - 1] >= prices[length -2]){
            count += (prices[length - 1] - prices[preMax]);
        }
        return count;
    }
}
