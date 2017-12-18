import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> outerList = new ArrayList<>();
        LinkedList<Integer> innerList = new LinkedList<>();
        Arrays.sort(candidates);
        compute(0,outerList,innerList,candidates,target);
        return outerList;
    }
    public void compute(int start,List<List<Integer>> outerList, LinkedList<Integer> innerList,
                   int[] candidates, int target){
        if(target == 0){
            List<Integer> tmpList = new LinkedList<>(innerList);
            outerList.add(tmpList);
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            innerList.addLast(candidates[i]);
            compute(i,outerList,innerList,candidates,target-candidates[i]);
            innerList.removeLast();
        }
    }
}
