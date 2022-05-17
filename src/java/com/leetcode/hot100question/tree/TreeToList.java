package com.leetcode.hot100question.tree;

/**
 * @author jiang
 */
public class TreeToList {

    private Node start,pre;

    public Node treeToDoublyList(Node root) {
    //中序遍历
        if (root == null){
            return root;
        }
        dfs(root);
        start.left = pre;
        pre.right = start;
        return start;
    }

    public void dfs(Node root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == null){
            start = root;
        }else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        dfs(root.right);
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}