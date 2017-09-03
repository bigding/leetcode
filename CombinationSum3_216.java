import java.util.*;

public class CombinationSum3_216 {
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> outerList = new LinkedList<List<Integer>>();
        LinkedList<Integer> innerList = new LinkedList<Integer>();

        compute(outerList, innerList,0,0,0,k,n);
        return outerList;
    }
    public void compute(List<List<Integer>> outerList,LinkedList<Integer> innerList,
                        int curNum, int curDp, int sum, int k, int n){
        int size = innerList.size();
        if(size == 0 || innerList.get(size - 1) < n - sum){
            if(curDp == k - 1){
                if(n - sum < 10){
                    innerList.addLast(n - sum);
                    List<Integer> tmpList = new LinkedList<Integer>(innerList);
                    outerList.add(tmpList);
                    innerList.removeLast();
                    return;
                }
            }
            else{
                int i;
                if(size == 0)
                    i = 1;
                else
                    i =  innerList.get(size - 1) + 1;
                for( ; i < n - sum && i < 10; i++){
                    if(size == 0 || innerList.get(size - 1) < i){
                        innerList.addLast(i);
                        compute(outerList,innerList,i,curDp+1,sum+i,k,n);
                        innerList.removeLast();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3_216 obj = new CombinationSum3_216();
        System.out.println(obj.combinationSum3(3,7));
    }
}
