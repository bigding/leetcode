import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n){
        LinkedList<String>  list  = new LinkedList<String>();
        compute(n, 0, 0,0, "", list);
        return list;
    }
    void compute(int max, int num,int count, int posi, String str, List<String> list){
        if(str.length() == max*2){
            list.add(str);
        }
        else{
            if(num < max){
                compute(max,num+1, count+1, posi+1,str+"(",list);
            }
            if(count > 0){
                compute(max, num,count-1,posi+1, str+")",list);
            }
        }
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.generateParenthesis(3));
    }
}
