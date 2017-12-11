public class SplitANum {
    public int findNum(int m,int n){
        if(m == n){
            return 1;
        }
        else{
            int count = 0;
            for(int i = n; i < m; i++){
                if(i <= m - i){
                    count += findNum(m-i,i);
                }
            }
            return count+1;
        }
    }
    public static void main(String[] args) {
        SplitANum obj = new SplitANum();
        System.out.println(obj.findNum(5,1));
    }
}
