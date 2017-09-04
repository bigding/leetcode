public class ConvertBSTToGreaterTree_538 {
    int num = 0;
    public TreeNode convertBST(TreeNode root){
        convert(root);
        return root;
    }
    public void convert(TreeNode node){
        if(node != null){
            convert(node.right);
            num += node.val;
            node.val = num;
            convert(node.left);
        }
    }

    public static void main(String[] args) {

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