/*******
    ***created by bigding at 2017年06月27日 星期二 21时38分16秒
    ***introduce:
 *******/
import java.util.*;

public class bestTimeToBuyAndSellStock_121{
    public static int maxProfit(int[] prices){
        int length = prices.length;
        int[] bigNum = new int[length];
        int max = 0;
        for(int i = 0; i < length; i++){
            max = Math.max(max,prices[length - 1 -i]);
            bigNum[length - 1 -i] = max;
        }
        max = 0;
        for(int j = 0; j < length - 1; j++){
            if(prices[j] < bigNum[j+1]){
                max = Math.max(max,bigNum[j+1] - prices[j]);
            }
        }
        return max;
    }
}

