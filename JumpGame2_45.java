/*
*created by bigding at 2017年07月10日 星期一 22时34分14秒
*/

public class JumpGame2_45{
    /*贪心算法:
     *每次的最优局部解为将最远一步走到终点的点设置为终点,然后计数加一
     *例如[2,3,1,1,4] 第一步完成后的序列变为[2,3]
     *
     * 但是,直接双层遍历在最坏情况下时间复杂度为O(n^2),就像leetcode上测试用例50000个1组成的数组一样
     *可以先求出数组的最大值,如果里层计数值大于最大值,就跳出里层循环
     */
    public int jump(int[] nums){
        if(nums.length <= 1){
            return 0;
        }
        int maxValue = 0;
        for(int i = 0; i < nums.length; i++)
            maxValue = Math.max(maxValue,nums[i]);
        int length = nums.length, curMaxPosi=length-1;
        int count = 0, curlen = 0;
        for(int i = length - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                curlen++;
                if(nums[j] >= curlen){
                    curMaxPosi = j;
                }
                if(curlen > maxValue)
                    break;
            }
            if(curMaxPosi != i)
                count++;
            i = curMaxPosi + 1; //因为循环后还会减一,此处先加上一
            curlen = 0;
        }
        return count;
    }
}
