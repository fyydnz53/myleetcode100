package com.leetcode.hot100question.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author jiang
 */
public class RebuildTree {

    Map<Integer,Integer> indexMap = new HashMap<>();
    int[] pre;
    int[] in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        pre = preorder;
        in = inorder;
        return buildTree(0,0,inorder.length-1);
    }

    public TreeNode buildTree(int start,int in_start,int end){
        if (in_start > end){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[start]);
        Integer integer = indexMap.get(treeNode.val);
        treeNode.left = buildTree(start+1,in_start,integer-1);
        treeNode.right = buildTree(start+integer+1-in_start,integer+1,end);
        return treeNode;
    }

}
