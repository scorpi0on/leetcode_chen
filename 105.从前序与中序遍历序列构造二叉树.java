import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for(int i = 0; i < len; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, len-1, inorder, 0, len-1);
    }

    public TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if( preStart > preEnd || inStart > inEnd) return null;

        int offset = map.get(preorder[preStart]) - inStart;
        
        TreeNode root = new TreeNode(preorder[preStart]); 
        root.left = dfs(preorder, preStart + 1, preStart + offset, inOrder, inStart, inStart + offset -1);
        root.right = dfs(preorder, preStart+offset+1, preEnd, inOrder, inStart+offset+1, inEnd);
        return root;
    }

}
// @lc code=end

