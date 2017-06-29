/*******
    ***created by bigding at 2017年05月08日 星期一 11时35分54秒
    ***introduce:二叉前序遍历,不使用递归
 *******/
import java.util.*;

public class BinaryTreeInorderTraversal_94{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack =  new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if(!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                currentNode = tmp.right;
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
        binaryTreeInorderTraversal_94 bina = new binaryTreeInorderTraversal_94();
        list = bina.inorderTraversal(root);
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
