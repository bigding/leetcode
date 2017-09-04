public class MoveZeroes_283 {
    public void moveZeroes(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == 0) count++;
        int point = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0) nums[point++] = nums[i];
        }
        for(;point < nums.length; nums[point] = 0, point++);
    }
}
