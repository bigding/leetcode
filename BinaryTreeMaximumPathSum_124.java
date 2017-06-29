/*******
    ***created by bigding at 2017年05月10日 星期三 14时45分56秒
    ***introduce:求二叉树某个路径的最大和,此路径的相邻连个点为父子连接关系,并且不需要经过根节点
 *******/

public class BinaryTreeMaximumPathSum_124{
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        findTreeMax(root);
        return maxSum;
    }
    public int findTreeMax(TreeNode node){
        if(node == null)
            return 0;
        int maxLeft = Math.max(0,findTreeMax(node.left));
        int maxRight = Math.max(0,findTreeMax(node.right));
        int tmpMax = maxLeft + maxRight +node.val;
        if(maxSum < tmpMax)
            maxSum = tmpMax;
        return Math.max(maxLeft,maxRight)+node.val;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);

        TreeNode right2 = new TreeNode(2);
        TreeNode right3 = new TreeNode(3);
        TreeNode right4 = new TreeNode(4);

        root.left = left2;
        root.right = right2;
        left2.left = left3;
        left2.right = left4;
        right2.left = right4;
        right2.right = right3;

        binaryTreeMaximumPathSum_124 tree = new binaryTreeMaximumPathSum_124();
        System.out.println(tree.maxPathSum(root));
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
