public class FindTheDuplicateNumber_287 {
    public int rob(TreeNode root){
        int value = find(root, 0);
        return value;
    }
    public int find(TreeNode node, int status){
        if(node == null)
            return 0;
        else{
            int maxValue = 0;
            if(status == 0){
                maxValue = Math.max(maxValue,find(node.left,0)+
                        find(node.right,0));
                maxValue = Math.max(maxValue,find(node.left,1)+
                        find(node.right,1) + node.val);
            }
            else{
                maxValue = find(node.left,0)+find(node.right,0);
            }
            return maxValue;
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}
