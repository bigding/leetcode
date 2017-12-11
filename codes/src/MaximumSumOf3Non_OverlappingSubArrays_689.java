import java.util.Arrays;
import java.util.LinkedList;

public class MaximumSumOf3Non_OverlappingSubArrays_689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k){
        int[] reValue = new int[3],left = new int[nums.length],leftPosi = new int[nums.length],
                right = new int[nums.length], rightPosi = new int[nums.length];

        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmpCount = 0;
            if(i < nums.length - k + 1) {
                for (int j = i; j < i + k; j++) {
                    tmpCount += nums[j];
                }
            }
            else{
                for(int j = i; j < array.length; j++){
                    tmpCount += nums[j];
                }
            }
            array[i] = tmpCount;
        }
        left[0] = array[0];
        right[array.length - 1] = array[array.length-1];
        rightPosi[array.length - 1] = array.length -1;
        for(int i = 1; i < array.length; i++){
            if(array[i] > left[i-1]){
                left[i] = array[i];
                leftPosi[i] = i;
            }
            else{
                left[i] = left[i-1];
                leftPosi[i] = leftPosi[i-1];
            }
        }
        for(int i = array.length-2; i >= 0; i--){
            if(array[i] >= right[i+1]){
                right[i] = array[i];
                rightPosi[i] = i;
            }
            else{
                right[i] = right[i+1];
                rightPosi[i] = rightPosi[i+1];
            }
        }

        int max = 0;
        for(int i = k; i < array.length - k - 1; i++){
            int tmpValue = array[i] + left[i-k]+right[i+k];
            if(tmpValue > max){
                max = tmpValue;
                reValue[0] = leftPosi[i-k];
                reValue[1] = i;
                reValue[2] = rightPosi[i+k];
            }
        }

//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(leftPosi));
//        System.out.println(Arrays.toString(right));
//        System.out.println(Arrays.toString(rightPosi));
        return reValue;
    }

    /**测试*/
    public static void main(String[] args) {
        MaximumSumOf3Non_OverlappingSubArrays_689 obj = new MaximumSumOf3Non_OverlappingSubArrays_689();
        System.out.println(Arrays.toString(obj.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3)));
    }
}
