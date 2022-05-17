package com.leetcode.hot100question.array;

/**
 * @author jiang
 */
public class CircleRead {

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int[][] ints = new int[n][m];
        doInsert(ints,0,0,m-1,n-1,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ints[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }



    public static void doInsert(int[][] table,int startX,int startY,int endX,int endY,int startValue){

        if (startX > endX || startY >endY){
            return;
        }
        if (startX == endX && startY == endY){
            table[startX][startY] = startValue;
        }

        for (int i = startX;i < endX;i++){
            table[startY][i] = startValue++;
        }

        for (int i = startY ; i < endY ; i++){
            table[i][endX] = startValue++;
        }

        for (int i = endX; i> startX;i --){
            table[endY][i] = startValue++;
        }

        for (int i = endY; i> startY;i--){
            table[i][startX] = startValue++;
        }

        doInsert(table,startX+1,startY+1,endX-1,endY-1,startValue);
    }
}
