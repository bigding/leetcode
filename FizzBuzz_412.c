/*******
    ***created by bigding at 2017年05月02日 星期二 08时42分56秒
    ***introduce:3的倍数输出Fizz,5的倍数输出Buzz,15的倍数输出FizzBuzz
 *******/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void Reverse(char *arr){
    int num,i;
    char tmp;
//    printf("%s\n",arr);
    for(num = 0; arr[num] != '\0'; num++)
        ;
    for(i = 0; i < (num)/2; i++){
        tmp = arr[i];
        arr[i] = arr[num-1-i];
        arr[num-1-i] = tmp;
    }
}

char** fizzBuzz(int n,int* returnSize){
    int num = n,i,value,j = 0;
    char** arr = (char **)malloc(sizeof(char *)*num);
    char tmp[10] = " ";
    *returnSize = num;
    for(i = 0; i < num; i++){
        arr[i] = (char *)malloc(sizeof(char)*10);
        arr[i][0] = '\0';
    }
    for(int i = 1; i <= num; i++){
        if(i%15==0){
            strcat(arr[i-1],"FizzBuzz");
        }
        else if(i%5 == 0){
            strcat(arr[i-1],"Buzz");
        }
        else if(i%3 == 0){
            strcat(arr[i-1],"Fizz");
        }
        else{
            value = i;
            while(value > 0){
                tmp[j++] = (value%10)+'0';
                value /= 10;
            }
            tmp[j] = '\0';
            j = 0;
            Reverse(tmp);
            strcat(arr[i-1],tmp);
        }
    }
    return arr;
}

