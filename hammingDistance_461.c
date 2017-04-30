/*******
    ***created by bigding at 2017年04月28日 星期五 20时43分19秒
    ***introduce:
 *******/

#include<stdio.h>

int hammingDistance(int, int);

int hammingDistance(int x, int y){
    int a=x, b=y,biteA= 0, biteB = 0;
    int  num = 0;
    while(a != 0 || b != 0){
        if(a % 2 != b % 2)
            num ++;
        a >>= 1;
        b >>= 1;
    }
    return num;
}

int main(){
    printf("%d\n",hammingDistance(1,4));
    return 0;
}
