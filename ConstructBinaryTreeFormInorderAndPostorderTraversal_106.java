/*******
    ***created by bigding at 2017年05月09日 星期二 21时23分48秒
    ***introduce:根据中序遍历和后序遍历求二叉树
 *******/

public class ConstructBinaryTreeFormInorderAndPostorderTraversal_106{
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return buildTree(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    public TreeNode buildTree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend ){
        if(instart >= inend){
            return null;
        }
        else if(instart == inend - 1){
            TreeNode tmp = new TreeNode(inorder[instart]);
            return tmp;
        }
        else{
            TreeNode tmp = new TreeNode(0);
            tmp.val = postorder[postend-1];
            int posiIn = findPosi(inorder,postorder[postend-1]);
            int length = posiIn - instart;
            tmp.left = buildTree(inorder,instart,posiIn,postorder,poststart,poststart+length);
            tmp.right = buildTree(inorder,posiIn+1,inend,postorder,poststart+length,postend-1);
            return tmp;
        }
    }
    int findPosi(int[] arr, int num){
        int i;
        for(i = 0; i < arr.length&&arr[i] != num; i++)
            ;
        return i;
    }
    public static void main(String[] args){
        int[] a = {1,3,2};
        int[] b = {3,2,1};
        constructBinaryTreeFormInorderAndPostorderTraversal_106 build = new constructBinaryTreeFormInorderAndPostorderTraversal_106();
        TreeNode root = build.buildTree(a,b);
        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
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

