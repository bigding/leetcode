/*******
    ***created by bigding at 2017年05月08日 星期一 21时33分11秒
    ***introduce:二叉树的后序遍历,非递归
 *******/
import java.util.*;

public class binaryTreePostorderTraversal_145{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> status = new LinkedList<Integer>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode);
                status.push(1);
                currentNode = currentNode.left;
            }
            if(!stack.isEmpty()){
                TreeNode tmp = stack.getFirst();
                int tmpStatus= status.pop();
                if(tmpStatus == 1){
                    status.push(0);
                    currentNode = tmp.right;
                }
                else{
                    tmp = stack.pop();
                    list.add(tmp.val);
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        TreeNode root = new TreeNode(1);
        TreeNode rightnode = new TreeNode(2);
        TreeNode rightleftnode = new TreeNode(3);
        root.right = rightnode;
        rightnode.left = rightleftnode;
        binaryTreePostorderTraversal_145 bina = new binaryTreePostorderTraversal_145();
        list = bina.postorderTraversal(root); 
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
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
