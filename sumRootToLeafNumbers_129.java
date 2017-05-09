/*******
    ***created by bigding at 2017年05月09日 星期二 10时29分08秒
    ***introduce:二叉树每个叶子节点代表一个数字,如1->2->3代表123.求所有叶子节点的和
 *******/
import java.util.*;

public class sumRootToLeafNumbers_129{
    LinkedList<Integer> nodeNums = new LinkedList<Integer>();//用于存放节点对应的数值
    LinkedList<Integer> status = new LinkedList<Integer>();//用于存放分支节点被访问的次数
    int nums = 0;
    public int sumNumber(TreeNode root){
        nodeNums.push(0);
        countNumber(root);
        return nums;
    }
    void countNumber(TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                int tmp = nodeNums.getFirst();
                nums += tmp*10+root.val;
            }
            else{

                int tmp = nodeNums.getFirst();
                nodeNums.push(tmp*10+root.val);
                countNumber(root.left);
                countNumber(root.right);
                tmp = nodeNums.pop();
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
