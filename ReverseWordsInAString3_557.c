/*******
    ***created by bigding at 2017年04月30日 星期日 14时09分01秒
    ***introduce: 翻转句子里面的单个字词
 *******/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void reverse(char *arr){
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

char* reverseWords(char* s){
    //需要将数组定义的大一点,不然leetcode测试用例会溢出
    char tmp[1000];
    char arr[10000];
    int i,num = 0;
    char *out = arr;
    out[0] = '\0';
    for(i = 0; ; i++){
        if(s[i] != ' '&& s[i] != '\0'){
            tmp[num++] = s[i]; 
        }
        else if(s[i] == ' '){
            tmp[num] = '\0';
            reverse(tmp);
            strcat(out,tmp);
            strcat(out," ");
            num = 0;
        }
        else if(s[i] == '\0'){
            tmp[num] = '\0';
            reverse(tmp);
            strcat(out,tmp);
            break;
        }
    }
//    printf("%s\n",out);
    return out;
}

int main(){
    char arr[] = "hello world";
    char *words = arr;
    int i ;
//    reverse(words);
//    for(i = 0; words[i] != '\0'; i++){
//        printf("%c",words[i]);
//    }
//    printf("\n");
    printf("%s\n",words);
    printf("%s\n",reverseWords(words));
    return 0;
}
