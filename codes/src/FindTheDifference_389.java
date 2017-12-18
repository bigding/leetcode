import java.util.Arrays;

public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        //  只有一个地方不同  所以可以将所有的字符异或
        int a = 0;
        for(int i = 0; i < s.length(); i++)
            a ^= s.charAt(i);
        for(int i = 0; i < t.length(); i++)
            a ^= t.charAt(i);
        return (char)a;
        /*   常规做法
        char[] arrA = s.toCharArray();
        char[] arrB = t.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int length = Math.min(arrA.length,arrB.length);
        for(int i = 0; i < length; i++){
            if(arrA[i] != arrB[i])
                if(arrA.length > arrB.length)
                    return arrA[i];
                else return arrB[i];
        }
        if(arrA.length > arrB.length)
            return arrA[length];
        return arrB[length];
        */
    }
}
