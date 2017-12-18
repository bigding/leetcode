import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    public List<String> LetterCombinations(String digits){
        char[][] array = {
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'},
        };
        LinkedList<String> list = new LinkedList<String>();
        if(digits.length() == 0){
            return list;
        }
        compute(0,digits.length(), "",digits,array, list);
        return list;
    }
    void compute(int num, int length,String value,String digits,char[][] array, List<String> list){
        if(num == length){
            list.add(value);
            return;
        }
        else{
            int chNum = digits.charAt(num) - '0';
            for(int i = 0; i < array[chNum-2].length; i++){
                compute(num+1, length, value+array[chNum - 2][i], digits,array,list);
            }
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_17 obj = new LetterCombinationsOfAPhoneNumber_17();
        System.out.println(obj.LetterCombinations(""));
    }
}

