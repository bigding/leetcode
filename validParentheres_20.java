/*******
    ***created by bigding at 2017年05月19日 星期五 15时12分58秒
    ***introduce:判断给定的()[]{}序列是否合法
 *******/
import java.util.*;

public class validParentheres_20{
    public static boolean isValid(String s){
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                char tmp = stack.pop();
                if(tmp == '('){
                    continue;
                }
                else{
                    return false;
                }
            }
            else if(s.charAt(i) == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                char tmp = stack.pop();
                if(tmp == '['){
                    continue;
                }
                else{
                    return false;
                }
            }
            else if(s.charAt(i) == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char tmp = stack.pop();
                if(tmp == '{'){
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        String str = "({{})[]{}";
        System.out.println(isValid(str));
    }
}
