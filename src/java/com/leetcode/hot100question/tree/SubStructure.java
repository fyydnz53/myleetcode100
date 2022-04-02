package com.leetcode.hot100question.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        List<TreeNode> root = Collections.singletonList(A);
        while (!root.isEmpty()) {
            List<TreeNode> treeNodes = new ArrayList<>();
            for (TreeNode treeNode : root) {
                if (isEqual(treeNode,
                        B)) {
                    return true;
                }else {
                    if (treeNode.left != null){
                        treeNodes.add(treeNode.left);
                    }
                    if (treeNode.right != null){
                        treeNodes.add(treeNode.right);
                    }
                }
            }
            root = treeNodes;
        }
        return false;
    }

    public boolean isEqual(TreeNode A, TreeNode B) {
        if (Objects.equals(A,
                B)) {
            return true;
        }

        if (A == null || B == null || A.val != B.val) {
            return false;
        }

        return isEqual(A.left,
                B.left) && isEqual(A.right,
                B.right);
    }
}
