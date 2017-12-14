import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int size = queue.size();
        double sum = 0;
        while(!queue.isEmpty()){
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.removeFirst();
                sum += tmp.val;
                if(tmp.left != null)
                    queue.addLast(tmp.left);
                if(tmp.right != null)
                    queue.addLast(tmp.right);
            }
            list.add(sum/size);
            size = queue.size();
            sum = 0;
        }
        return list;
    }
}
