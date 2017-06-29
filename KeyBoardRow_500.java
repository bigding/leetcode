/*******
    ***created by bigding at 2017年05月02日 星期二 20时01分04秒
    ***introduce:给定一个字符串数组,返回一个字符串数组,其中每个元素(字符串)的字母都在键盘输入的一排上
 *******/
import java.util.*;

public class KeyBoardRow_500{
    public static String[] findWords(String[] words){
//        System.out.println("hello");
        String[] alphabat = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };
//        for(int m = 0; m < words.length; m++){
//            System.out.println(words[m]);
//        }
        List<String> arr = new ArrayList<String>();

        for(int i = 0; i < words.length; i++){
            boolean flag = true;
            String[] tmp = words[i].split("");
//            System.out.println(tmp[0]+"\t"+tmp.length);
            int num = 0;
            for(int j = 0; j < 3; j++){
                if(alphabat[j].contains(tmp[0].toLowerCase())){
                    num = j;
                    break;
                }
            }
//            System.out.println(num);
            for(int k = 1; k < tmp.length; k++){
                if(!alphabat[num].contains(tmp[k].toLowerCase())){
                    flag = false;
//                    System.out.println(flag+"\t"+tmp[k]);
                    break;
                }
            }
            if(flag){
                arr.add(words[i]);
//                System.out.println(words[i]);
            }
        }
//        System.out.println(arr);
        return arr.toArray(new String[arr.size()]);
    }
    public static void main(String[] args){
        String[] input = {
            "Hello",
            "Alaska",
            "Dad",
            "Peace"
        };
        String[] output = findWords(input);
//        System.out.println(output);
//        System.out.println(output.length);
        for(int i = 0; i < output.length; i++){
            System.out.println(output[i]);
        }
    }
}
