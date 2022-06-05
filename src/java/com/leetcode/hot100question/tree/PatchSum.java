package com.leetcode.hot100question.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiang
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class PatchSum {
    private List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //直接前序遍历
        dfs(root,target,new LinkedList<>());
        return lists;
    }

    public void dfs(TreeNode node,int target,LinkedList<Integer> parent){
        if (node == null ) {
            return;
        }
        parent.add(node.val);
        if (target == node.val && node.left == null && node.right == null){
            lists.add(new LinkedList<>(parent));
            parent.removeLast();
            return;
        }
        dfs(node.left,target-node.val,parent);
        dfs(node.right,target-node.val,parent);
        parent.removeLast();
    }
}
