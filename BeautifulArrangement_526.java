/*******
    ***created by bigding at 2017年05月05日 星期五 17时33分56秒
    ***introduce:求优美排列,思路为求全排列,然后在其中筛选出来合格的组合
 *******/
import java.util.Scanner;

public class BeautifulArrangement_526{
    static int num = 0;
    public static  int countArrangement(int N){
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        arrange(arr,0,arr.length-1);
        return num;
    }
    public static void main(String[] args){
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        System.out.println(countArrangement(number));
    }
    public static void arrange(int[] arr,int start, int length){
        if(start == length){
            if((arr[length]%(length+1)==0)||(length+1)%arr[length] ==0){
//                for(int i = 0; i < length+1; i++){
//                    System.out.print(arr[i]+"\t");
//                }
//                System.out.println();
                num++;
            }  
      }
        else{
            for(int i = start; i <= length; i++){
                swap(arr,start,i);
                if((arr[start]%(start+1) == 0|| (start+1)%arr[start] == 0))
                    arrange(arr,start+1,length);
                swap(arr,start,i);
            }
        }
    }
    static void swap(int[] arr,int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
