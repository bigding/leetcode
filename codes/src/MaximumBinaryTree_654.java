public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getNode(0, nums.length -1, nums);
    }
    public TreeNode getNode(int left, int right, int[] nums){
        if(left > right)
            return null;
        if(left == right){
            return new TreeNode(nums[left]);
        }

        TreeNode node = null;
        int maxPosi = 0, max = Integer.MIN_VALUE;
        for(int m = left; m <= right; m++){
            if(nums[m] > max){
                max = nums[m];
                maxPosi = m;
            }
        }
        node = new TreeNode(max);
        node.left = getNode(left,maxPosi-1,nums);
        node.right = getNode(maxPosi+1, right,nums);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
