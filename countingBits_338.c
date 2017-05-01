/*******
    ***created by bigding at 2017年05月01日 星期一 11时03分30秒
    ***introduce:求小于等于给定数字的所有数字的二进制格式中1的位数,并返回数组. 要求时间复杂度和空间复杂度都为O(n)
    ***思路为用递归的思想,f(0)=0;f(1)=1;f(n)=f(n/2)+f(n%2) n > 1
 *******/

#include<stdio.h>
#include<stdlib.h>

int* countBits(int num, int* returnSize){
    int i;
    *returnSize = num+1;
    int *arr = (int *)malloc(sizeof(int)*(num+1));
    arr[0] = 0;
    for(i = 1; i <= num; i++){
        if(i == 1)
            arr[i] = 1;
        else{
            arr[i] = arr[i/2]+arr[i%2];           
        }       
    }
    return arr;
}

int main(){
    int num = 5,i;
    int arr[100];
    int *count = (int *)malloc(sizeof(int)*(num+1));
    count = countBits(num,arr);
    for(i = 0; i <= num; i++){
        printf("%d\n",count[i]);
    }
    return 0;
}
