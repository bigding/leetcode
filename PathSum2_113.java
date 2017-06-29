/*******
    ***created by bigding at 2017年05月09日 星期二 11时06分04秒
    ***introduce:给定一个二叉树和一个和(数字).判断是否存在root-to-leaf路径,如果存在,则讲所有路径用List返回.root-to-left示例,1>3>9>10 即为23
 *******/
import java.util.*;

public class PathSum2_113{
    LinkedList<List<Integer>> outerList = new LinkedList<List<Integer>>();
    LinkedList<Integer> innerList = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        isSum(root,sum);
        return outerList;
    }
    public void isSum(TreeNode root,int number){
        if(root != null){
             if(root.left == null && root.right == null){
                if(number == 0){
                    innerList.push(root.val);
                    List<Integer> tmpList = new LinkedList<Integer>(innerList);
                    Collections.reverse(tmpList);
                    outerList.add(tmpList);
                    innerList.pop();
                }        
            }
            else{
                int tmp = root.val;
                innerList.push(tmp);
                isSum(root.left,number-tmp);
                isSum(root.right,number-tmp);
                innerList.pop();
            }
        }
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
