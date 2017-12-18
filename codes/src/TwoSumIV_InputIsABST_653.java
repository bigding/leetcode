public class TwoSumIV_InputIsABST_653 {
    TreeNode rootNode;
    public boolean findTarget(TreeNode root, int k) {
        rootNode = root;
        return find(root, k);
    }
    public boolean find(TreeNode node, int k){
        if(node == null)
            return false;
        if(k == node.val * 2)
            return find(node.left,k) || find(node.right,k);
        return findNum(rootNode,k - node.val) || find(node.left,k) || find(node.right,k);
    }
    public boolean findNum(TreeNode node,int num){
        if(node == null)
            return false;
        if(num == node.val)
            return true;
        if(node.val < num)
            return findNum(node.right, num);
        return findNum(node.left, num);
    }
}
