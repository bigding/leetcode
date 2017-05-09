/*******
    ***created by bigding at 2017年05月09日 星期二 15时50分28秒
    ***introduce:求二叉树的最小深度,注意判断分支节点为空或只有一边有子节点的情况
 *******/
public class mininumDepthOfBinaryTree_111{
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;

        }
        if(root.left == null && root.right == null){
            return 1;

        }
        if(root.left == null){
            return minDepth(root.right)+1;

        }
        if(root.right == null){

            return minDepth(root.left)+1;

        }
        int leftdeep = minDepth(root.left);
        int rightdeep = minDepth(root.right);
        if(leftdeep > rightdeep)
            return rightdeep +1;
        return leftdeep + 1;
    }
}
