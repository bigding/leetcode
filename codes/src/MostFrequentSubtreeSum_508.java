import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum_508 {
    int max = 1;
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        int length = 0;
        getSum(root);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() == max)
                length++;
        }
        System.out.println(length+"\t"+max);
        int[] maxSum = new int[length];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() == max){
                maxSum[i++] = entry.getKey();
                System.out.println(entry.getKey()+"\t"+entry.getValue());
            }
        }
        return maxSum;
    }
    public int getSum(TreeNode node){
        if(node == null)
            return 0;
        else{
            int sum = getSum(node.left) + getSum(node.right)+node.val;
            if(map.containsKey(sum)){
                int tmp = map.get(sum);
                map.put(sum,tmp+1);
                max = Math.max(max, tmp+1);
            }
            else{
                map.put(sum,1);
            }
            return sum;
        }
    }
}
