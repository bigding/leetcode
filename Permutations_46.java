import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums){
        LinkedList<List<Integer>> outer = new LinkedList<List<Integer>>();
        LinkedList<Integer> inner = new LinkedList<Integer>();
        int[] tip = new int[nums.length];
        Arrays.fill(tip, 0);
        per(outer, inner, 0, nums,tip);
        return outer;
    }
    public void per(LinkedList<List<Integer>> outer, LinkedList<Integer> inner, int posi, int[] nums,int[] tip){
        if(posi == nums.length){
            List<Integer> tmp = new LinkedList<>(inner);
            outer.add(tmp);
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(tip[i] == 0){
                    tip[i] = 1;
                    inner.addLast(nums[i]);
                    per(outer, inner, posi+1, nums, tip);
                    inner.removeLast();
                    tip[i] = 0;
                }
            }
        }
    }
}
