/*******
    ***created by bigding at 2017年06月28日 星期三 09时13分48秒
    ***introduce:
 *******/
import java.util.*;

public class findLargestValueInEachTreeRow_515{
    public static List<Integer> largestValues(TreeNode root){
        List<Integer> largeV = new ArrayList<Integer>();
        List<TreeNode> fList = new ArrayList<TreeNode>();
        List<TreeNode> sList = new ArrayList<TreeNode>();
        if(root == null){
            return largeV;
        }
        fList.add(root);
        largeV.add(root.val);
        boolean status = true;
        while(fList.size() > 0 || sList.size() >0){
            int max = Integer.MIN_VALUE;
            boolean hasMax = false;
            if(status){
                if(fList.size() != 0){
                    for(int i = 0; i < fList.size(); i++){
                        if(fList.get(i).left != null){
                            sList.add(fList.get(i).left);
                            max = Math.max(max,fList.get(i).left.val);
                            hasMax = true;
                        }
                        if(fList.get(i).right != null){
                            sList.add(fList.get(i).right);
                            max = Math.max(max,fList.get(i).right.val);
                            hasMax = true;
                        }
                    }
                }
                fList.clear();
                status = false;
            }
            else{
                if(sList.size() != 0){
                    for(int i = 0; i < sList.size(); i++){
                        if(sList.get(i).left != null){
                            fList.add(sList.get(i).left);
                            max = Math.max(max,sList.get(i).left.val);
                            hasMax = true;
                        }
                        if(sList.get(i).right != null){
                            fList.add(sList.get(i).right);
                            max = Math.max(max, sList.get(i).right.val);
                            hasMax = true;
                        }
                    }
                }
                sList.clear();
                status = true;
            }
            if(hasMax){
                largeV.add(max);
            }
        }
        return largeV;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
