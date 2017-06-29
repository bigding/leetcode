/*******
    ***created by bigding at 2017年05月10日 星期三 17时59分42秒
    ***introduce:蛇形层次遍历
 *******/
import java.util.*;

public class PopulatingNextRightPointersInEachNode_116{
    LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    TreeLinkNode preNode = null;
    public void connent(TreeLinkNode root){
        if(root == null){
            return;
        }
        queue.offer(root);
        traversal(queue.size());
    }
    void traversal(int num){ 
        int count = 0;
        int numTmp = num;
        if(numTmp > 0){
            while(numTmp > 0&&!queue.isEmpty()){
                TreeLinkNode tmpNode = queue.poll();
                if(preNode == null && numTmp == 1){
                    
                }
                else if(preNode == null && numTmp != 1){
                    preNode = tmpNode;
                }
                else if(preNode != null){
                    preNode.next = tmpNode;
                    preNode = tmpNode;
                }
                if(numTmp == 1){
                    preNode = null;
                }
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
            traversal(count);
        }
    }
    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left2 = new TreeLinkNode(2);
        TreeLinkNode left3 = new TreeLinkNode(3);
        TreeLinkNode left4 = new TreeLinkNode(4);

        TreeLinkNode right2 = new TreeLinkNode(5);
        TreeLinkNode right3 = new TreeLinkNode(6);
        TreeLinkNode right4 = new TreeLinkNode(7);

        root.left = left2;
        root.right = right2;
        left2.left = left3;
        left2.right = left4;
        right2.left = right4;
        right2.right = right3;

        populatingNextRightPointersInEachNode_116 tree = new populatingNextRightPointersInEachNode_116();
        tree.connent(root);
    }

}
class TreeLinkNode{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode(int x){
        val = x;
    }
}
