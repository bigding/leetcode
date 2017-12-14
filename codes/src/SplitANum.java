import java.util.LinkedList;
import java.util.List;

public class SplitANum {
    LinkedList<Integer> stack = new LinkedList<>();
    List<LinkedList<Integer>> list = new LinkedList<>();
    public int findNum(int m,int n){
//        System.out.println(m+"\t"+n);
        stack.push(m);
        LinkedList<Integer> tmp = new LinkedList<>(stack);
        list.add(tmp);
        stack.pop();
        if(m == n){
            return 1;
        }
        else{
            int count = 0;
            for(int i = n; i < m; i++){
                if(i <= m - i){
                    stack.push(i);
                    count += findNum(m-i,i);
                    stack.pop();
                }
            }
            return count+1;
        }
    }
    public void showList(){
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                System.out.print(list.get(i).get(j)+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        SplitANum obj = new SplitANum();
        int num = obj.findNum(5,1);
        obj.showList();
        System.out.println();
        System.out.println(num);
    }
}
