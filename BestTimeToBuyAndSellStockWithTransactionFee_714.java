import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {

    public int maxProfit(int[] prices, int fee){
        int l = prices.length;
        int[] hold = new int[l+1];
        int[] nothold = new int[l+1];
        hold[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= l; i++){
            hold[i] = Math.max(hold[i - 1], nothold[i-1] - prices[i-1] - fee);
            nothold[i] = Math.max(nothold[i-1],hold[i-1]+prices[i-1]);
        }
        return nothold[l];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee_714 obj = new BestTimeToBuyAndSellStockWithTransactionFee_714();
        System.out.println(obj.maxProfit(new int[]{8,2,8,4,9},2));
    }
}
