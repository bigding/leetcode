/*******
    ***created by bigding at 2017年05月11日 星期四 17时51分37秒
    ***introduce:将二叉树转化成LinkedList
 *******/
import java.util.*;

public class FlattenBinaryTreeToLinkedList_114{
    LinkedList<Integer> valList = new LinkedList<Integer>();
    public void flatten(TreeNode root){
        if(root != null){
            getValList(root);
            root.left = null;
            TreeNode tmpNode = buildTree();
            root.right = tmpNode.right;
        }
    }
    public TreeNode buildTree(){
        if(valList.isEmpty()){
            return null;
        }
        TreeNode tmpNode = new TreeNode(valList.poll());
        tmpNode.right = buildTree();
        return tmpNode;
    }
    public void getValList(TreeNode node){
        if(node != null){
            valList.offer(node.val);
            getValList(node.left);
            getValList(node.right);
        }
    }
    public static void main(String[] args){
        TreeNode root =new TreeNode(1);
        TreeNode left2 =new TreeNode(2);
        TreeNode left3 =new TreeNode(3);
        TreeNode left4 =new TreeNode(4);
        TreeNode right5 =new TreeNode(5);
        TreeNode right6 =new TreeNode(6);

        root.left = left2;
        root.right = right5;
        left2.left = left3;
        left2.right = left4;
        right5.right = right6;
        
        flattenBinaryTreeToLinkedList_114 treeCase = new flattenBinaryTreeToLinkedList_114();
        treeCase.flatten(root);
        System.out.println(root.right.right.val);
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
