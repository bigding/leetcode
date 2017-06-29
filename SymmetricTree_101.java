/*******
    ***created by bigding at 2017年05月10日 星期三 13时59分21秒
    ***introduce:判断一个二叉树是否是轴对称的
 *******/

public class SymmetricTree_101{
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        else if(left == null || right == null){
            return false;
        }
        else{
            if(left.val != right.val){
                return false;
            }
            return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        }
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

        symmetricTree_101 symme = new symmetricTree_101();
        System.out.println(symme.isSymmetric(root));
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
