package com.leetcode.hot100question.string;

public class Replace {
    public String replaceSpace(String s) {
        byte[] bytes = s.getBytes();
        int n = 0;
        for (int i = 0; i < bytes.length; i++){
            if (bytes[i] == ' '){
                n ++;
            }
        }
        if (n == 0){
            return s;
        }
        byte[] b2 = new byte[bytes.length + 2 * n];
        int n2 = 0;
        for (int i = 0,j=0; i < bytes.length; i++){
            if (n2 <= n && bytes[i] == ' '){
                b2[j] = '$';
                b2[j+1] = '2';
                b2[j+2] = '0';
                n2++;
                j += 3;
            }else {
                j += 1;
                b2[j] = bytes[i];
            }
        }

        return new String(b2);
    }
}
