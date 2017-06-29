/*******mZ    ***created by bigding at 2017年05月03日 星期三 15时36分06秒
    ***introduce:求最深层的最左元素
 *******/

public class FindBottomLeftTreeValue_513{
    static int result = 0;
    public static  int findBottomLeftTreeValue(TreeNode root){
        findMostLeft(root,deep(root));
        return result;
    }
    public static void findMostLeft(TreeNode root,int deep){
        if(root != null){
            if(deep == 1){
                result = root.val;
                return;
            }
            findMostLeft(root.left,deep - 1);
            findMostLeft(root.right,deep -1);
        }
    }
    //求二叉树的深度
    public static int deep(TreeNode root){
        int leftdeep = 0,rightdeep = 0;
        if(root == null)
            return 0;
        if(root.left != null)
            leftdeep = deep(root.left);
        if(root.right != null)
            rightdeep = deep(root.right);
        if(leftdeep > rightdeep)
            return leftdeep+1;
        else
            return rightdeep+1;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        System.out.println(findBottomLeftTreeValue(root));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

