/*******
    ***created by bigding at 2017年05月19日 星期五 10时52分41秒
    ***introduce:使用逆波兰表达式求一个式子的值
 *******/
import java.util.*;

public class EvaluateReversePolishNotation_150{
    public static int evalRPN(String[] tokens){
        LinkedList<String> stack = new LinkedList<String>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].matches("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int value = b/a;
                stack.push(String.valueOf(value));
            }
            else if(tokens[i].matches("\\*")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int value = b*a;
                stack.push(String.valueOf(value));
            }
            else if(tokens[i].matches("\\+")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int value = b+a;
                stack.push(String.valueOf(value));
            }
            else if(tokens[i].matches("\\-")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int value = b-a;
                stack.push(String.valueOf(value));
            }
            else if(tokens[i].matches("\\%")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int value = b%a;
                stack.push(String.valueOf(value));
            }
            else{
                stack.push(tokens[i].toString());
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args){
        String[] arr = {"0","3","/"};
        System.out.println(evalRPN(arr));
    }
}
