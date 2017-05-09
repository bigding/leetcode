/*******
    ***created by bigding at 2017年05月09日 星期二 11时06分04秒
    ***introduce:给定一个二叉树和一个和(数字).判断是否存在root-to-leaf路径.root-to-left示例,1>3>9>10 即为23
 *******/

public class pathSum_112{
    public boolean hasPathSum(TreeNode root, int sum){
        return isSum(root,0,sum);
    }
    public boolean isSum(TreeNode root,int num, int sum){
        if(root == null){
            return false;
        }
        else if(root.left == null && root.right == null){
            if(num+root.val == sum)
                return true;
            else
                return false;
        }
        else{
            return isSum(root.left,num+root.val,sum)||isSum(root.right,num+root.val,sum);
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
