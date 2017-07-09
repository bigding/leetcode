/*******
    ***created by bigding at 2017年07月09日 星期日 23时01分00秒
    ***introduce:
 *******/

public class JumpGame_55{
    public boolean canJump(int[] nums){
        if(nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        int count = 0;
        int curPosi = nums.length -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= ++count){
                count = 0;
                curPosi = i;
            }
        }
        if(curPosi == 0)
            return true;
        return false;
    }
}
