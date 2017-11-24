import java.util.Arrays;

public class MimimumASCIIDeleteSumForTwoStrings_712 {
    int[][] tip;
    //非递归的解法
    public int minimumDeleteSum2(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        tip = new int[arr1.length+1][arr2.length+1];
        for(int i = arr1.length; i >= 0; i--){
            for(int j = arr2.length; j >= 0; j--){
                if(i == arr1.length){
                    int sum = 0;
                    for(int m = j; m < arr2.length; m++)
                        sum += arr2[m];
                    tip[i][j] = sum;
                }
                else if(j == arr2.length){
                    int sum = 0;
                    for(int m = i; m < arr1.length; m++)
                        sum += arr1[m];
                    tip[i][j] = sum;
                }
                else if(arr1[i] == arr2[j]) {
                    tip[i][j] = tip[i + 1][j + 1];
                }
                else{
                    tip[i][j] = Math.min(tip[i+1][j]+arr1[i],tip[i][j+1]+arr2[j]);
                }
            }
        }
        return tip[0][0];
    }
    //递归的解法
    public int minimumDeleteSum(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        tip = new int[arr1.length+1][arr2.length +1];
        for(int[] inner:tip)
            Arrays.fill(inner, 0);
        return findNum(0,0,arr1,arr2);
    }
    public int findNum(int m,int n, char[] arr1, char[] arr2){
        if(tip[m][n] == 0) {
            int sum = 0;
            if (m >= arr1.length) {
                for (int i = n; i < arr2.length; i++)
                    sum += arr2[i];
            }
            else if (n >= arr2.length) {
                for (int i = m; i < arr1.length; i++)
                    sum += arr1[i];
            }
            else if(arr1[m] == arr2[n])
                sum = findNum(m+1,n+1,arr1,arr2);
            else{
                sum = Math.min(findNum(m+1,n,arr1,arr2)+arr1[m],
                        findNum(m,n+1,arr1,arr2)+arr2[n]);
            }
            tip[m][n] = sum;
        }
        return tip[m][n];
    }

    public static void main(String[] args) {
        MimimumASCIIDeleteSumForTwoStrings_712 obj = new MimimumASCIIDeleteSumForTwoStrings_712();
        System.out.println(obj.minimumDeleteSum2("delete","leet"));
    }
}
