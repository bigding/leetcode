/*******
    ***created by bigding at 2017年05月20日 星期六 00时48分42秒
    ***introduce:使用堆栈实现,从左至右扫描,遇到比前面先有高度高的就进栈,一旦遇到比前一个小的就出栈并更新,如此循环,直至结束
 *******/
import java.util.*;

public class largestRectangleInHistogram_84{
    public static int largestRectangleArea(int[] heights){
        LinkedList<Rect> stack = new LinkedList<Rect>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            if(i == 0){
                stack.push(new Rect(heights[i],1));
            }    
            else{
                if(stack.peek().height == heights[i])
                    stack.peek().width += 1;
                if(stack.peek().height < heights[i])
                    stack.push(new Rect(heights[i],1));
                else{
                    while(stack.peek().height > heights[i]){
                        Rect tmpRect1 = stack.pop();
                        maxArea = Math.max(maxArea,tmpRect1.height * tmpRect1.width);
                        if(stack.isEmpty()||stack.peek().height <= heights[i]){
                            tmpRect1.height = heights[i];
                            stack.push(tmpRect1);
                            i--;
                            break;
                        }
                        else{
                            stack.peek().width += tmpRect1.width;
                        }
                    }
                }
            }
        }
        while(!stack.isEmpty()){
//            System.out.println("a\t"+stack.peek().height+"\t"+stack.peek().width);
            Rect tmpRect = stack.pop();
            maxArea = Math.max(maxArea,tmpRect.width*tmpRect.height);
            if(!stack.isEmpty())
                stack.peek().width += tmpRect.width;
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] arr = {3,5,0,2,5,5};
        System.out.println(largestRectangleArea(arr));
    }
}
class Rect{
    int width;
    int height;
    Rect(int a,int b){
        height = a;
        width = b;
    }
}
