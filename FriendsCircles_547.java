import java.util.Arrays;

public class FriendsCircles_547 {
    public int findCircleNum(int[][] M){
        int[] tip = new int[M.length];
        int count = 0;
        Arrays.fill(tip,0);
        for(int i = 0; i < M.length; i++){
            if(tip[i] == 0){
                search(tip, i, M);
                count++;
                System.out.println(count);
            }
        }
        return count;
    }
    public void search(int[] tip, int i, int[][] M){
        System.out.println("outer:"+);
        if(tip[i] == 0){
            for(int j = 0; j < M.length; j++){
                if(M[i][j] == 1){
                    tip[j] = 1;
                    search(tip, j, M);
                }
            }
        }
    }
}
