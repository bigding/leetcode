import java.util.LinkedList;

public class MajorityElement_169 {
    public int majorityElement(int[] nums){
        LinkedList<Integer> stack = new LinkedList<>();
        for(int num:nums){
            if(stack.isEmpty())
                stack.push(num);
            else if(num == stack.getLast())
                stack.push(num);
            else
                stack.pop();
        }
        return stack.get(0);
    }
}
