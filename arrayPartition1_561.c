/*******
    ***created by bigding at 2017年04月28日 星期五 15时34分43秒
    ***introduce:
 *******/

#include<stdio.h>
#include<stdlib.h>

int arrayPairSum(int *, int);
void Qsort(int v[], int left, int right);
void Swap(int v[], int a,int b);


int main(){
    int arr[] = {1,2,5,3};
    int num = sizeof(arr)/sizeof(int);
    Qsort(arr,0,num-1);
    printf("%d,%d,%d,%d\n",arr[0],arr[1],arr[2],arr[3]);
    printf("%d\n",arrayPairSum(arr,num));
    return 0;
}

int arrayPairSum(int* sum, int numsSize){
    int num = 0, i;
    Qsort(sum,0,numsSize-1);
    for(int i; i < numsSize; i++){
        if(i % 2 == 0){
            num += sum[i];
        }
    }
    return num;
}

void Qsort(int v[], int left, int right){
    int i, last;
    void Swap(int v[], int i, int j);

    if(left >= right){
        return;
    }
    Swap(v, left,  (right + left)/2);
    last = left;
    for(i = left + 1; i <= right; i++){
        if(v[i] < v[left]){
            Swap(v, ++last, i);
        }
    }
    Swap(v, last, left);
    Qsort(v, left, last - 1);
    Qsort(v,last+1, right);
}
void Swap(int v[], int a,int b){
    int tmp;
    tmp = v[a];
    v[a] = v[b];
    v[b] = tmp;
}
