import java.util.*;

public class PartitionToKEqualSumSubsets_698 {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    public boolean canPartitionKSubsets(int[] nums, int k){
        if(k > nums.length)
            return false;
        int sum = 0;
        for(int i:nums)
            sum += i;
        if(sum % k != 0)
            return false;
        int avg = sum / k;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length/2; i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && !findOK(i,avg, nums)){
                return false;
            }
        }
        if(nums[0] != 0)
            return false;
        return true;
    }
    public boolean findOK(int m, int remain, int[] nums){
        if(remain == 0){
            while(!stack.isEmpty()){
                int i = stack.pop();
                nums[i] = 0;
            }
            return true;
        }
        if(m >= nums.length)
            return false;
        for(int i = m; i < nums.length; i++){
            if(nums[i] <= remain){
                stack.push(i);
                boolean status = findOK(i + 1, remain - nums[i], nums);
                if(status)
                    return true;
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets_698 obj = new PartitionToKEqualSumSubsets_698();
        System.out.println(obj.canPartitionKSubsets(new int[]{1,1,2,4},4));
    }
}
