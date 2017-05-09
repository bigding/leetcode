/*******
    ***created by bigding at 2017年05月09日 星期二 17时10分51秒
    ***introduce:根据二叉树的前序遍历和中序遍历复原二叉树
 *******/

public class constructBinaryTreeFormPreorderAndInorderTraversal_105{
    public TreeNode buildTree(int[] preorder,int[] inorder){
        return buildTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend ){
        if(prestart >= preend){
            return null;
        }
        else if(prestart == preend - 1){
            TreeNode tmp = new TreeNode(preorder[prestart]);
            return tmp;
        }
        else{
            TreeNode tmp = new TreeNode(0);
            tmp.val = preorder[prestart];
            int posiIn = findPosi(inorder,preorder[prestart]);
            int length = posiIn - instart;
            tmp.left = buildTree(preorder,prestart+1,prestart+1+length,inorder,instart,posiIn);
            tmp.right = buildTree(preorder,prestart+1+length,preend,inorder,posiIn+1,inend);
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
        int[] a = {1,2,3};
        int[] b = {2,3,1};
        constructBinaryTreeFormPreorderAndInorderTraversal_105 build = new constructBinaryTreeFormPreorderAndInorderTraversal_105();
        TreeNode root = build.buildTree(a,b);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);
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
