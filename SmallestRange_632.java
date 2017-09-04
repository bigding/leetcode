import javafx.beans.property.ReadOnlyIntegerWrapper;

import java.util.*;

public class SmallestRange_632 {
    public int[] smallestRange(List<List<Integer>> nums){
        /*int[] 存（value,list中位置,二级list中位置）*/
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int maxValue = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        int minRange_min = Integer.MAX_VALUE;
        int minRange_max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            int value = nums.get(i).get(0);
            maxValue= Math.max(maxValue,value);
            queue.add(new int[]{value,i,0});
        }
        while(true){
            int[] minArr = queue.poll();
            int minValue = minArr[0];
            if(maxValue - minValue < minRange){
                minRange_min = minValue;
                minRange_max = maxValue;
                minRange = maxValue - minValue;
            }
            System.out.println(minRange_min+"\t"+minRange_max);
            if(minArr[2] >= nums.get(minArr[1]).size() - 1){
                break;
            }
            int tmpValue = nums.get(minArr[1]).get(minArr[2] + 1);
            if(tmpValue > maxValue){
                maxValue = tmpValue;
            }
            queue.add(new int[]{tmpValue, minArr[1],minArr[2] + 1});
        }
        return new int[]{minRange_min,minRange_max};
    }
}
