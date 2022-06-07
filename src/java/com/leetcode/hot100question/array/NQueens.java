package com.leetcode.hot100question.array;

/**
 * @author jiang
 */
public class NQueens {

    public static void main(String[] args) {
        int i = new NQueens().totalNQueens(4);
        System.out.println(i);
    }

    private int[][] chessboard;
    private int count = 0;
    int n;

    public int totalNQueens(int n) {
        chessboard = new int[n][n];
        this.n = n;
        dfs(0);
        return count;
    }

    private void dfs(int x){
        for (int i = 0; i < n; i++) {
            if (chessboard[x][i] == 0){
                //如果到最后一行了，那就直接返回就行了
                if(x == n-1) {
                    count++;
                    return;
                }
                //放置棋子
                putChess(x,i,1);
                dfs(x+1);
                putChess(x,i,-1);
            }
        }
    }

    private void putChess(int x, int i, int value) {
        chessboard[x][i] += value;
        //横默认不用管，直接到下一排了
        //向下棋盘的全部竖更新
        for(int j = x+1;j<n;j++){
            chessboard[j][i] += value;
        }
        //\斜向更新
        for (int k = x+1,l=i+1;k<n && l<n;k++,l++){
            chessboard[k][l] += value;
        }
        // /斜向更新
        for (int k = x+1,l=i-1;k<n && l >= 0;k++,l--){
            chessboard[k][l] += value;
        }
    }

}
