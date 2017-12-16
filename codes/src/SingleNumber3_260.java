import java.util.Arrays;

public class SingleNumber3_260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num:nums){
            xor ^= num;
        }
        xor &= -xor;
        int[] re = {0,0};
        for(int num:nums){
            if((num & xor) == 0){
                re[0] ^= num;
            }
            else{
                re[1] ^= num;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        SingleNumber3_260 obj = new SingleNumber3_260();
        System.out.println(Arrays.toString(obj.singleNumber(new int[]{-1,0})));
    }
}
