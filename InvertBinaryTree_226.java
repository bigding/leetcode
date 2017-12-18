import sun.reflect.generics.tree.Tree;

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root){
        invert(root);
        return root;
    }
    public void invert(TreeNode root){
        if(root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
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