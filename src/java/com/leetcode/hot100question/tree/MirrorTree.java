package com.leetcode.hot100question.tree;

import java.util.TreeMap;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = tmp;
        return root;
    }
}
