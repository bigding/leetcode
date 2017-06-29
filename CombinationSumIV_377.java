/*******
    ***created by bigding at 2017年06月27日 星期二 19时16分34秒
    ***introduce:
 *******/

public class CombinationSumIV_377{
    public static int combinationSum4(int[] nums, int target){
        int[] tip = new int[target + 1];
        for(int i = 0; i < tip.length; i++){
            tip[i] = -1;
        }
        return f(0, target, nums, tip); 
    }
    public static int f(int n, int target, int[] arr, int[] tip){
        if(n ==  target)
            return 1;
        else if(n > target)
            return 0;
        else{
//            System.out.println("!:"+n);
//            System.out.println(tip[n]);
            if(tip[n] == -1){
//                System.out.println(n);
                int max = 0;
                for(int i = 0; i < arr.length; i++){
                    max += f(n + arr[i], target, arr, tip);
                }
                tip[n] = max;
            }
            return tip[n];
        }
    }
    public static void main(String[] args){
        int[] arr = {3,33,333};
        int value = combinationSum4(arr, 10000);
        System.out.println(value);
    }
}
