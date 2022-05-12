package com.leetcode.hot100question.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiang
 */
public class IsBlindTree {



    /**
     * 后序遍历特点,左< 右？ > 根
     * 分治算法解决问题
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }

    public boolean verify(int[] postorder,int start,int end){
        if (start >= end){
            return true;
        }
        int split = end - 1;
        int root = postorder[end];
        boolean re = false;
        for (int i = start;i < end ;i++){
            if (!re && postorder[i] > root){
                split = i-1;
                re = true;
            }
            if (re && postorder[i] < root){
                return false;
            }
        }
        return verify(postorder,start,split) && verify(postorder,split + 1,end - 1);
    }

}
