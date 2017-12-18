import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayNesting_565 {
    public int arratNesting(int[] nums){
        int max = 0;
        int[] tip = new int[nums.length];
        Arrays.fill(tip,-1);
        for(int i = 0; i < nums.length; i++){
            if(tip[i] == -1){
                int tmp = nums[i];
                tip[tmp] = 1;
                int step = 1;
                while(nums[tmp] != nums[i]){
                    step++;
                    tmp = nums[tmp];
                    tip[tmp] = 1;
                }
                max = Math.max(max, step);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayNesting_565 obj  = new ArrayNesting_565();
        System.out.println("out:"+obj.arratNesting(new int[]{
                5,4,0,3,1,6,2
        }));
    }
}
