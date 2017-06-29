/*******
    ***created by bigding at 2017年05月03日 星期三 10时55分31秒
 *******/

public class NextGreaterElement1_496{
    public static int[] nextGreaterElement(int[] findNums, int[] nums){
        int[] output = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++){
            boolean status = false,flag = false;
            for(int j = 0; j < nums.length; j++){
                if(!status && nums[j] == findNums[i]){
                    status = true;
                }
                else if(status){
                    if(nums[j] > findNums[i]){
                        output[i] = nums[j];
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag)
                output[i] = -1;
        }
        return output;
    }
    public static void main(String[] args){

    }
}
