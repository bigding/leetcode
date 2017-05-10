/*******
    ***created by bigding at 2017年05月10日 星期三 21时46分40秒
    ***introduce:判断二叉树是不是平衡二叉树
 *******/

public class balancedBinaryTree_110{
    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;
        else{
            int deepDiff = Math.abs(treeDeep(root.left)-treeDeep(root.right));
            return (deepDiff <= 1)&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int treeDeep(TreeNode node){
        if(node == null){
            return 0;
        }
        int deepleft = treeDeep(node.left);
        int deepright = treeDeep(node.right);
        return Math.max(deepleft,deepright)+1;
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
        balancedBinaryTree_110 testCase = new balancedBinaryTree_110();
        System.out.println(testCase.isBalanced(root));
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
