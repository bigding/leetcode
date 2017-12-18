import java.util.Arrays;

public class DeleteOperationForTwoStrings_583 {
    public int minDistance(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] tip = new int[w1.length+1][w2.length+1];
        for(int[] arr:tip)
            Arrays.fill(arr,-1);
        int remainNum = find(0,0,w1,w2,tip);
        return w1.length + w2.length - remainNum * 2;
    }
    /*找到完成所有删除后剩余的字符的数量*/
    public int find(int m, int n, char[] w1, char[] w2, int[][] tip){
        if(m >= w1.length || n >= w2.length){
            return 0;
        }
        if(tip[m][n] == -1){
            int maxValue = 0;
            maxValue = Math.max(maxValue, find(m+1, n, w1,w2,tip));
            maxValue = Math.max(maxValue, find(m,n +1, w1,w2,tip));
            if(w1[m] == w2[n]){
                maxValue = Math.max(maxValue, find(m+1, n+1 ,w1,w2,tip) + 1);
            }
            tip[m][n] = maxValue;
        }
        return tip[m][n];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings_583 obj = new DeleteOperationForTwoStrings_583();
        System.out.println(obj.minDistance("horse","ros"));
    }
}