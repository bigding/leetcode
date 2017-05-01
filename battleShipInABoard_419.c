/*******
    ***created by bigding at 2017年04月30日 星期日 23时21分10秒
    ***introduce: 用矩阵表示甲板和船,求船的数量 要求求解复杂度为O(1),并且不修改矩阵原有的值
    *** 思路为: 如果有相邻的船只,那么必定存在这样一个点,其在不是直线的两个方向上的侧边同时存在其他的点,先排除这样的点,再对其他的点求值.和原题相比,本答案做多了,oj上给的例子都是合法的,本答案当例子不合法时返回-1
 *******/

#include<stdio.h>

int countBattleships(char** board, int boardRowSize, int boardColSize){
    int i,j,l,r,t,b,num = 0;
    for(i = 0; i < boardRowSize; i++){
        for(j = 0; j < boardColSize; j++){
            /* 求解各个点四侧是否有X */
            if(board[i][j] == 'X'){
                if(i == 0)
                    t = 0;
                else{
                    if(board[i-1][j] == 'X')
                        t = 1;
                    else
                        t = 0;
                }
                if(i == boardRowSize - 1)
                    b = 0;
                else{
                    if(board[i+1][j] == 'X')
                        b = 1;
                    else
                        b = 0;
                }
                if(j == 0){
                    l = 0;
                }
                else{
                    if(board[i][j-1] == 'X')
                        l = 1;
                    else
                        l = 0;
                }
                if(j == boardColSize - 1){
                    r = 0;
                }
                else{
                    if(board[i][j+1] == 'X')
                        r = 1;
                    else
                        r = 0;
                }
                /* 判断是否合理,以及是否构成船 */
                if((l==1 && t==1)||(t == 1 && r == 1)||(r == 1&& b == 1)||(b == 1&& l == 1)){
                    return -1;
                }
                if(t == 0 && l == 0)
                    num++;
            }
        }
    }
    return num;
}
int main(){ 
    char* arr[]={ 
        "X..X", 
        "...X",
        "...X" 
    };
    printf("%d\n",countBattleships(arr,4,3)); 
}
