/*******
    ***created by bigding at 2017年05月07日 星期日 16时07分11秒
    ***introduce:给定连个二叉树,验证是否相同
 *******/

public class SameTree_100{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q != null)||(p!=null && q == null))
            return false;
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            else{
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }
        }
        else{
            return true;
        }
    }
}
