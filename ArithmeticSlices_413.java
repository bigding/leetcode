/*******
    ***created by bigding at 2017年05月03日 星期三 19时31分31秒
    ***introduce:
 *******/

public class ArithmeticSlices_413{
    public static int numberOfArithmeticSlices(int[] A){
        int num = 0,count = 0,dist = 0,loop = 0;
        boolean status = true;
        int i;
        for(i = 1; i < A.length;i++){
//            System.out.println("i:"+i);
            if(status){
                dist = A[i] - A[i-1]; 
                status = false;
                num++;
            }
            else{
                if(A[i] - A[i-1] == dist){
                    num++;
                }
                else{
                    status = true;
                }
            }
            if(status || i == A.length - 1){
//                System.out.println("num:"+num);
                num++;
                loop++;
                if(num > 2){
                    count += (num -1)*(num-2)/2;
                }
                if(loop == 10){
                    return -1;
                }
                if(status&&num==2)
                    i--;
                num = 0;
            }
            
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2,1,3,4,2,3};
        System.out.println(numberOfArithmeticSlices(arr));
    }
}

