import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ShoppingOffers_638 {
    Map<String,Integer> tip = new HashMap<String, Integer>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        StringBuilder builder = new StringBuilder("#");
        for(int i = 0; i < needs.size(); i++){
            builder.append(needs.get(i));
            builder.append("#");
        }
        if(tip.containsKey(builder.toString())){
            return tip.get(builder.toString());
        }
        else{
            int min = Integer.MAX_VALUE;
            for(int  m = 0; m < special.size(); m++){
                int length = special.get(0).size();
                boolean isUse = true;
                for(int n = 0; n < length - 1; n++){
                    if(special.get(m).get(n) > needs.get(n)){
                        isUse = false;
                        break;
                    }
                }
                if(isUse) {
                    List<Integer> newNeeds = new LinkedList<>();
                    for (int n = 0; n < length - 1; n++) {
                        newNeeds.add(needs.get(n) - special.get(m).get(n));
                    }
                    min = Math.min(min,shoppingOffers(price,special,newNeeds) + special.get(m).get(length-1));
                }
            }
            int remainCount = 0;
            for(int i = 0; i < needs.size(); i++){
                remainCount += (needs.get(i)*price.get(i));
            }
            min = Math.min(min,remainCount);
            tip.put(builder.toString(),min);
            return min;
        }
    }

    /*测试部分*/
    public static void main(String[] args) {
        ShoppingOffers_638 obj = new ShoppingOffers_638();

        int[] arr1 = new int[]{2,5};
        List<Integer> price = new LinkedList<>();
        addToList(price,arr1);
        int[] arr2 = new int[]{3,2};
        List<Integer> needs = new LinkedList<>();
        addToList(needs, arr2);

        int[][] arr3 = {
                {3,0,5},
                {1,2,10}
        };
        List<List<Integer>> special = new LinkedList<>();
        addTo2List(special, arr3);

        System.out.println(obj.shoppingOffers(price, special,needs));
    }
    public static void addToList(List<Integer> list, int[] arr){
        for(int  i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
    }
    public static void addTo2List(List<List<Integer>> lists, int[][] arr){
        for(int m = 0; m < arr.length; m++){
            List<Integer> list = new LinkedList<>();
            for(int n = 0; n < arr[0].length; n++){
                list.add(arr[m][n]);
            }
            lists.add(list);
        }
    }
}
