package com.leetcode.hot100question.array;

public class FindStr {

    public static void main(String[] args) {
        FindStr findStr = new FindStr();
        char[][] chars = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        findStr.exist(chars,word);
    }
    public boolean exist(char[][] board, String word) {
        int high = board.length;
        int wide = board[0].length;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                        //递归开搞
                    if (getWord(board,word,i,j,0,high,wide)){
                        return true;
                    }
            }
        }
        return false;
    }

    private boolean getWord(char[][] board, String word,int i,int j,int start,int hight,int wide){
        if (i<hight && j<wide && i>=0 && j>=0 && board[i][j] == word.charAt(start)){
            if(start == word.length() - 1){
                return true;
            }
            start ++;
            board[i][j] = '\0';
            boolean result = getWord(board,word,i+1,j,start,hight,wide) ||
                    getWord(board,word,i-1,j,start,hight,wide) ||
                    getWord(board,word,i,j+1,start,hight,wide) ||
                    getWord(board,word,i,j-1,start,hight,wide);
            board[i][j] = word.charAt(start-1);
            if (result){
                return true;
            }
        }
        return false;
    }
}
