/*******
    ***created by bigding at 2017年05月07日 星期日 17时08分26秒
    ***introduce:前序遍历,不使用递归
 *******/
import java.util.*;

public class binaryTreePreorderTraversal{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                list.add(currentNode.val);
                System.out.println("val:"+currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if(!stack.isEmpty()){
                TreeNode tmp = stack.pop();
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
        binaryTreePreorderTraversal bina = new binaryTreePreorderTraversal();
        list = bina.preorderTraversal(root);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(list.size());
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
