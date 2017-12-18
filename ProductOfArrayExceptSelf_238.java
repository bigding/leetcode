import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExpectSelf(int[] nums){
        int sum = 1;
        int zero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                sum *= nums[i];
            }
            else{
                zero++;
            }
        }
        int[] array = new int[nums.length];
        if(zero > 1){
            Arrays.fill(array,0);
            return array;
        }
        for(int i = 0 ; i < array.length; i++){
            if(nums[i] == 0){
                array[i] = sum;
            }
            else if(zero == 1){
                array[i] = 0;
            }
            else{
                array[i] = sum/nums[i];
            }
        }
        return array;
    }
}
