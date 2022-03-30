package com.leetcode.hot100question.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        List<TreeNode> nodes = Collections.singletonList(root);
        while (!nodes.isEmpty()){
           List<TreeNode> treeNodes = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            nodes.forEach(node->{
                if(node.left != null){
                    treeNodes.add(node.left);
                }
                if (node.right != null){
                    treeNodes.add(node.right);
                }
                result.add(node.val);
            });
            lists.add(result);
            nodes = treeNodes;
        }
        return lists;
    }

    public int[] levelOrder2(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null){
            return new int[0];
        }
        List<TreeNode> nodes = Collections.singletonList(root);
        while (!nodes.isEmpty()){
            List<TreeNode> treeNodes = new ArrayList<>();
            nodes.forEach(node->{
                if(node.left != null){
                    treeNodes.add(node.left);
                }
                if (node.right != null){
                    treeNodes.add(node.right);
                }
                lists.add(node.val);
            });
            nodes = treeNodes;
        }
        int[] ints = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            ints[i] = lists.get(i);
        }
        return ints;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        int i = 1;
        while (!nodes.isEmpty()){
            Stack<TreeNode> treeNodes = new Stack<>();
            ArrayList<Integer> result = new ArrayList<>();
            TreeNode  node;
            while (!nodes.isEmpty()){
               node = nodes.pop();
                if ((i & 1) == 1) {
                    if (node.left != null) {
                        treeNodes.push(node.left);
                    }
                    if (node.right != null) {
                        treeNodes.push(node.right);
                    }
                }else {
                    if (node.right != null) {
                        treeNodes.push(node.right);
                    }
                    if (node.left != null) {
                        treeNodes.push(node.left);
                    }
                }
                result.add(node.val);
            }
            lists.add(result);
            nodes = treeNodes;
            i++;
        }
        return lists;
    }

}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
