import java.util.Arrays;

public class DeleteAndEarn_740 {
    public int deleteAndEarn(int[] nums) {
        int[] array = new int[10003];
        int maxValue = 0;
        for(int i = 0; i < nums.length; i++){
            array[nums[i]]++;
            maxValue = Math.max(maxValue,nums[i]);
        }
        int[] max = new int[maxValue+3];
        for(int n = maxValue; n > 0; n--){
            max[n] = Math.max(max[n+1],max[n+2]+array[n]*n);
        }
        System.out.println(Arrays.toString(max));
        return max[1];
    }

    public static void main(String[] args) {
        DeleteAndEarn_740 obj = new DeleteAndEarn_740();
        System.out.println(obj.deleteAndEarn(new int[]{3,4,2}));
    }
}
