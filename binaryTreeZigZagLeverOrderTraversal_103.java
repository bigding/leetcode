/*******
    ***created by bigding at 2017年05月10日 星期三 17时59分42秒
    ***introduce:蛇形层次遍历
 *******/
import java.util.*;

public class binaryTreeZigZagLeverOrderTraversal_103{
    List<List<Integer>> backList = new LinkedList<List<Integer>>();
    List<Integer> innerList = new LinkedList<Integer>();
    LinkedList<TreeNode> stack1 = new LinkedList<TreeNode>();
    LinkedList<TreeNode> stack2 = new LinkedList<TreeNode>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        stack1.push(root);
        innerList.add(root.val);
        backList.add(new LinkedList<Integer>(innerList));
        innerList.clear();
        traversal(false);
        return backList;
    }
    void traversal(boolean dirc){  //dict指示遍历方向.真为正向便利,假为逆向遍历
        if(!dirc){
            while(!stack1.isEmpty()){
                TreeNode tmpNode = stack1.pop();
                if(tmpNode.right != null){
                    innerList.add(tmpNode.right.val);
//                    System.out.println(tmpNode.right.val);
                    stack2.push(tmpNode.right);
                }
                if(tmpNode.left != null){
                    innerList.add(tmpNode.left.val);
 //                   System.out.println(tmpNode.left.val);
                    stack2.push(tmpNode.left);
                }
            }
            if(!stack2.isEmpty()){
                backList.add(new LinkedList<Integer>(innerList));
                innerList.clear();
                traversal(!dirc);
            }
        }
        else{
            while(!stack2.isEmpty()){
                TreeNode tmpNode = stack2.pop();
                if(tmpNode.left != null){
                    innerList.add(tmpNode.left.val);
  //                  System.out.println(tmpNode.left.val);
                    stack1.push(tmpNode.left);
                }
                if(tmpNode.right != null){
                    innerList.add(tmpNode.right.val);
   //                 System.out.println(tmpNode.right.val);
                    stack1.push(tmpNode.right);
                }
            }
            if(!stack1.isEmpty()){
                backList.add(new LinkedList<Integer>(innerList));
                innerList.clear();
                traversal(!dirc);
            }
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);

        TreeNode right2 = new TreeNode(5);
        TreeNode right3 = new TreeNode(6);
        TreeNode right4 = new TreeNode(7);

        root.left = left2;
        root.right = right2;
        left2.left = left3;
        left2.right = left4;
        right2.left = right4;
        right2.right = right3;

        binaryTreeZigZagLeverOrderTraversal_103 tree = new binaryTreeZigZagLeverOrderTraversal_103();
        List<List<Integer>> outer = new LinkedList<List<Integer>>();
        List<Integer> inner = new LinkedList<Integer>();
        outer = tree.zigzagLevelOrder(root);
        System.out.println(outer);
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
