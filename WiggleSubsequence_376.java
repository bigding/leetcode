public class WiggleSubsequence_376 {
    public int wiggleMaxLength(int[] nums){
        if(nums.length < 2)
            return nums.length;
        int length = 1;
        int flag = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(flag == 0){
                if(nums[i] < nums[i+1]){
                    length++;
                    flag = 1;
                }
                if(nums[i] > nums[i+1]){
                    length++;
                    flag = -1;
                }
            }
            if(flag == 1 && nums[i] > nums[i+1]){
                length++;
                flag = -1;
            }
            if(flag == -1 && nums[i] < nums[i+1]){
                length++;
                flag = 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        WiggleSubsequence_376 obj = new WiggleSubsequence_376();
        System.out.println(obj.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
