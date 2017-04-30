/*******
    ***created by bigding at 2017年04月30日 星期日 16时59分41秒
    ***introduce:求给定数字的补码
 *******/

#include<stdio.h>

int findComplement(int num){
    long i=1;           //必须定义为long数据类型,因为c语言中int只有16位
    if(num == 2147483647)      //排除边界可能运算溢出的情况
        return 0;
    while((i = 2*i) < num +1)
        ;
    return i - 1 -num;
}

int main(){
    printf("%d\n",findComplement(1));
    return 0;
}
