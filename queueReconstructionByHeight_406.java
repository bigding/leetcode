/*******
    ***created by bigding at 2017年06月21日 星期三 13时50分52秒
    ***introduce:
 *******/
import java.util.*;

public class queueReconstructionByHeight{
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
    /*两次快排将这个二维数组排序*/
    public static void sortArray(int[][] array){
        sortOuter(array,0,array.length - 1);
        int prePosi = 0;
        showArray(array);
        System.out.println();
        for(int i = 1; i < array.length; i++){
            if(array[i][0] != array[i-1][0]){
                if(i - prePosi > 1){
                    System.out.println("prePosi1:" + prePosi +"\t" + (i-1) );
                    sortInner(array,prePosi,i-1);
                }
                prePosi = i;
            }
            if(i == array.length-1 && i > prePosi){
                System.out.println("prePosi2:" + prePosi +"\t" + i );
                sortInner(array,prePosi,i);
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
    public static int[][] reconstructQueue(int[][] people){
        if(people.length < 2){
            return people;
        }
        sortArray(people);
        showArray(people);
        System.out.println();
        List<mapValue> list = new ArrayList<mapValue>();
        for(int i = 0; i < people.length; i++){
            if(list.size() == 0){
                list.add(new mapValue(people[i][0],people[i][1]));
            }
            else{
                int firstNum = people[i][0];
                int secondNum = people[i][1];
                int countBig = 0;
                if(secondNum == 0){
                    list.add(0,new mapValue(people[i][0],people[i][1]));
                    continue;
                }
                else{
                    for(int j = 0; j < list.size(); j++){
                        if(list.get(j).a >= firstNum){
                            countBig++;
                            if(countBig == secondNum){
                                list.add(j+1,new mapValue(people[i][0],people[i][1]));
                                continue;
                            }
                        }
                        if(j == list.size() - 1 && countBig < secondNum){
                            list.add(j +1 ,new mapValue(people[i][0],people[i][1]));
                            break;
                        }
                    }
                }
            }
        }
        showArray(people);
        System.out.println();
        int[][] returnArr = new int[people.length][people[0].length];
        for(int k = 0; k < list.size(); k++){
            returnArr[k][0] = list.get(k).a;
            returnArr[k][1] = list.get(k).b;
        }
        return returnArr;
    }
    public static void main(String[] args){
        int[][] arr = {
            {7,2},
            {1,4},
            {9,1},
            {3,1},
            {9,0},
            {1,0}
        };
        int[][] outValue = reconstructQueue(arr);
        System.out.println("result:");
        showArray(outValue);
    }
}
class mapValue{
    int a;
    int b;
    mapValue(int x,int y){
        a = x;
        b = y;
    }
}
