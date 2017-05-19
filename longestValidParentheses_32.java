/*******
    ***created by bigding at 2017年05月19日 星期五 15时33分15秒
    ***introduce:接20题,求最长的合法序列()[]{}长度
 *******/
import java.util.*;

public class longestValidParentheses_32{
    public static int longestValidParentheses(String s){
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0, left = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                if(stack.isEmpty()) left = i;
                else{
                    int tmp = stack.pop();
                    if(stack.isEmpty()) max = Math.max(max,i-left);
                    else max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        String str = "(()";
        System.out.println(longestValidParentheses(str));
    }
}
