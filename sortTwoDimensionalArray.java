/*******
    ***created by bigding at 2017年06月21日 星期三 14时08分04秒
    ***introduce:
 *******/

public class sortTwoDimensionalArray{
    public static void swap(int[][] array, int i, int j){
        //System.out.println("swapPre:\n" +  array[i][0] + "\t" + array[i][1]);
        //System.out.println(array[j][0] + "\t" + array[j][1]);
        int[] tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void sortOuter(int[][] array,int left, int right){
        if(left >= right){
            return;
        }
        else{
            swap(array,left,(left+right)/2);
            int last = left;
            for(int i = left + 1; i <= right; i++){
                if(array[i][0] > array[left][0])
                    swap(array,++last, i);
            }
            swap(array,last, left);
            sortOuter(array,left,last -1);
            sortOuter(array,last + 1, right);
        }
    }
    public static void sortInner(int[][] array,int left, int right){
        //System.out.println();
        //System.out.println();
        //System.out.println("posi:"+left + "\t" + right);
        if(left >= right){
            return;
        }
        else{
            swap(array,left,(left+right) / 2);
            int last = left;
            for(int i = left+1; i <= right; i++){
                if(array[i][1] < array[left][1])
                    swap(array,++last,i);;
            }
            swap(array,left,last);
            sortInner(array,left,last - 1);
            sortInner(array,last+1, right);
        }
    }
    public static void sortArray(int[][] array){
        sortOuter(array,0,array.length - 1);
        int prePosi = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i][0] != array[i-1][0]){
                //System.out.println("prePosi" + prePosi +"\t" + i);
                sortInner(array,prePosi,i-1);
                prePosi = i;
            }
        }
    }
    public static void showArray(int[][] array){
        for(int[] outer : array){
            for(int inner : outer){
                System.out.print(inner + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] valueArr = {
            {7,0},
            {4,4},
            {7,1},
            {5,0},
            {6,1},
            {6,9},
            {6,2},
            {12,2},
            {332,2},
            {6,2},
            {0,2},
            {9,1},
            {5,2},
        };
        //System.out.println("preArray:");
        //showArray(valueArr);
        sortArray(valueArr);
        //System.out.println("result:");
        showArray(valueArr);
    }
}
