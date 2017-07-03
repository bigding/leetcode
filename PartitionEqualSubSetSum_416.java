/*******
    ***created by bigding at 2017年07月01日 星期六 22时40分59秒
    ***introduce:
 *******/

public class PartitionEqualSubSetSum_416{
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int[][] tip = new int[nums.length + 1][sum/2 +1];
        for(int i = 0; i < tip.length; i++){
            for(int j = 0; j < tip[0].length; j++){
                tip[i][j] = -1;
            }
        }
        boolean num = f(0,sum/2, nums, tip);
        System.out.println(num);
        System.out.println();
        System.out.println();
        for(int i = 0; i < tip.length; i++){
            for(int j = 0; j < tip[0].length; j++){
                System.out.print(tip[i][j]+"\t");
            }
            System.out.println();
        }
        return num;
    }
    boolean f(int n, int sum, int[] nums, int[][] tip){
        if(sum == 0){
            return true;
        }
        if(sum < 0 || n > nums.length - 1){
            return false;
        }
        if(tip[n][sum] == -1){
            boolean status = true;
            for(int i = n; i < nums.length; i++){
                System.out.println(i+"\t"+sum+"\t"+nums[i]);
                status = f(i + 1, sum - nums[i], nums, tip);
                if(status == true){
                    break;
                }
            }
            if(status){
                tip[n][sum] = 1;
            }
            else
                tip[n][sum] = 0;
        }
        if(tip[n][sum] == 0){
            return false;
        }
        else
            return true;
    }
    //下面的方法是求满足条件的组合的数量,但是当数据量大了过后,会存在int数值溢出问题,所有不用下面的这个思路来求解
    /*
    int  f(int n, int curNum,int sum, int[] nums, int[][] tip){
        if(curNum == sum){
            return 1;
        }
        if(curNum > sum){
            return 0;
        }
        if(n > nums.length){
            return 0;
        }
        if(tip[n][curNum] == -1){
            int value = 0;
            for(int k = n; k < nums.length; k++){
                value += f(k+1, curNum+nums[k], sum, nums, tip);
            }
            System.out.println(value);
        int[] nums = {1,5,11,5};
        }
        return tip[n][curNum];
    }*/
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        PartitionEqualSubSetSum_416 obj = new PartitionEqualSubSetSum_416();
        System.out.println(obj.canPartition(nums));
    }
}
