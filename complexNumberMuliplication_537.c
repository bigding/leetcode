/*******
    ***created by bigding at 2017年04月29日 星期六 09时31分12秒
    ***introduce: 复数的加减运算
 *******/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>


char *complexNumberMultiply(char *a, char *b){
    int m, n, p, q, l, r,i,j,len;
    char *out = NULL;
    out = (char*)malloc(100);

    len = strlen(a);
    for(i = 0; i < len; i++){
        if(a[i] == '+' || a[i] == 'i')
            a[i] = ' ';
    }
    a[len-1] = '\0';
    sscanf(a,"%d %d",&m,&n);
    len = strlen(b);
    for(j = 0; j < len; j++){
        if(b[j] == '+' || b[j] == 'i')
            b[j] = ' ';
    }
    b[len-1] = '\0';
    sscanf(b,"%d %d",&p,&q);
    printf("%d,%d,%d,%d\n",m,n,p,q);
    l = m*p - n*q;
    r = n*p + m*q;
    sprintf(out,"%d+%di",l,r);
    return out;
}

int main(){
    int i;
    char arr1[] = "1+1i",arr12[] = "1+1i";
    char *a = arr1;
    char *b = arr12;
    char *c = (char *)malloc(100);
    c = complexNumberMultiply(a,b);
    printf("%s\n",c);
}
