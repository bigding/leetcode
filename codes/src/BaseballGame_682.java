import java.util.Arrays;

public class BaseballGame_682 {
    public int calPoints(String[] ops){
        // 将stack定义长一点 posi定义为2 是为了防止查询的时候 有index=-1  越界
        int[] stack = new int[ops.length+3];
        int posi = 2, sum = 0;
        for(int i = 0; i < ops.length ;i++){
            if(ops[i] == "+" || "+".equals(ops[i])){
                int tmpSum = stack[posi-1] + stack[posi-2];
                sum += tmpSum;
                stack[posi++] = tmpSum;
            }
            else if(ops[i] == "C" || "C".equals(ops[i])){
                sum -= stack[posi-1];
                posi--;
            }
            else if(ops[i] == "D" || "D".equals(ops[i])){
                sum += stack[posi-1]*2;
                stack[posi] = stack[posi-1]*2;
                posi++;
            }
            else{
                int value = Integer.valueOf(ops[i]);
                sum += value;
                stack[posi++] = value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballGame_682 obj = new BaseballGame_682();
        System.out.println(obj.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
