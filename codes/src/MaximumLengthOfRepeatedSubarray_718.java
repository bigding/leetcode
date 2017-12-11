import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray_718 {
    public int findLength(int[] A, int[] B) {
        int[][] tip = new int[A.length+1][B.length+1];
        int max = 0;
        for(int m = A.length - 1; m >= 0; m--){
            for (int n = B.length - 1; n >= 0; n--){
                if(A[m] != B[n]){
                    tip[m][n] = Math.max(tip[m+1][n],tip[m][n+1]);
                }
                else{
                    if(m+1<A.length && n+1 < B.length && A[m+1] == B[n+1]) {
                        tip[m][n] = tip[m + 1][n + 1] + 1;
                    }
                    else
                        tip[m][n] = 1;
                }
                max = Math.max(max,tip[m][n]);
            }
        }
        for(int[] inner:tip)
            System.out.println(Arrays.toString(inner));
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray_718 obj =new MaximumLengthOfRepeatedSubarray_718();
        System.out.println(obj.findLength(new int[]{5,14,53,80,48},new int[]{50,47,3,80,83}));
    }
}
