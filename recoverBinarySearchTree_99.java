/*******
    ***created by bigding at 2017年05月11日 星期四 09时56分55秒
    ***introduce:一颗二叉搜索树,打乱两个节点的位置,编写使用常数空间的算法
 *******/
import java.util.*;

public class recoverBinarySearchTree_99{
    int count = 0;
    TreeNode preNode = null;
    TreeNode swapNode1 = null;
    TreeNode swapNode2 = null;
    public void recoverTree(TreeNode root){
        traversal(root);
        int tmp= swapNode1.val;
        swapNode1.val = swapNode2.val;
        swapNode2.val = tmp;
    }
    public void traversal(TreeNode node){
        if(node == null)
            return;
        traversal(node.left);
        if(preNode != null){
            if(node.val < preNode.val){
                if(count == 0){
                    swapNode1 = preNode;
                    swapNode2 = node;
                    count++;
                }
                else{
                    swapNode2 = node;
                }
            }
        }
        preNode = node;
        traversal(node.right);
    }
    public static void main(String[] args){
       TreeNode root = new TreeNode(0);
       TreeNode leftNode = new TreeNode(1);

       root.left = leftNode;
       recoverBinarySearchTree_99 treeCase = new recoverBinarySearchTree_99();
       treeCase.recoverTree(root);
       System.out.println(root.val);
       System.out.println(root.left.val);
    }
}

class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(){}
     TreeNode(int x){
         val = x;
     }
}
