import java.util.Arrays;

public class PalindromicSubstrings_647 {
    int count = 0;
    public int countSubstring(String s){
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            find(arr,i,i);
            find(arr,i,i+1);
        }
        return count;
    }
    public void find(char[] arr, int left, int right){
        while(left >= 0 && right < arr.length && arr[left] == arr[right]){
            count++;
            left--;
            right++;
        }
    }
}
