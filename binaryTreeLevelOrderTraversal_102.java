/*******
    ***created by bigding at 2017年05月10日 星期三 17时59分42秒
    ***introduce:蛇形层次遍历
 *******/
import java.util.*;

public class binaryTreeLevelOrderTraversal_102{
    List<List<Integer>> backList = new LinkedList<List<Integer>>();
    List<Integer> innerList = new LinkedList<Integer>();
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return backList;
        }
        queue.offer(root);
        traversal(queue.size());
        return backList;
    }
    void traversal(int num){ 
        System.out.println(num);
        int count = 0;
        int numTmp = num;
        if(numTmp > 0){
            while(numTmp > 0&&!queue.isEmpty()){
                TreeNode tmpNode = queue.poll();
                innerList.add(tmpNode.val);
                if(tmpNode.left != null){
                    queue.offer(tmpNode.left);
                    count++;
                }
                if(tmpNode.right != null){
                    queue.offer(tmpNode.right);
                    count++;
                }
                numTmp--;
            }
            backList.add(new LinkedList<Integer>(innerList));
            innerList.clear();
            traversal(count);
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

        binaryTreeLevelOrderTraversal_102 tree = new binaryTreeLevelOrderTraversal_102();
        List<List<Integer>> outer = new LinkedList<List<Integer>>();
        List<Integer> inner = new LinkedList<Integer>();
        outer = tree.levelOrder(root);
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
