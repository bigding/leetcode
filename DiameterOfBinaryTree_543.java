public class DiameterOfBinaryTree_543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        return max;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            int leftMax = dfs(node.left);
            int rightMax = dfs(node.right);
            max = Math.max(max, leftMax + rightMax);
            return Math.max(leftMax, rightMax) + 1;
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