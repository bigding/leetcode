public class SingleNumber_136 {
    public int singleNumber(int[] nums){
        int value = nums[0];
        for(int i = 1; i < nums.length; i++){
            value ^= nums[i];
        }
        return value;
    }
}
