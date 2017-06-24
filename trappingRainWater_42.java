/*******
    ***created by bigding at 2017年05月21日 星期日 11时47分22秒
    ***introduce:使用栈实现,栈中存贮对象,对象的字段包括高和宽
 *******/
import java.util.*;

public class trappingRainWater_42{
    public static int trap(int[] height){
        int a = 0, b = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int area = 0;
        while(a <= b){
            if(leftMax < rightMax){
                if(leftMax > height[a]){
                    area += leftMax - height[a];
                }
                else if(leftMax < height[a]){
                    leftMax  = height[a];
                }
                a++;
            }
            else{
                if(rightMax > height[b]){
                    area += rightMax - height[b];
                }
                else if(rightMax < height[b]){
                    rightMax  = height[b];
                }
                b--;
            }
        }
        return area;
    }
    public static void main(String[] args){
        int[] arr = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(trap(arr));
    }
}
