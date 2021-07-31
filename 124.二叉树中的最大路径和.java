/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        oneSideMax(root);

        return ans;

    }

    public int oneSideMax(TreeNode root){

        if(root == null) {
            return 0;
        }

        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));

        ans = Math.max(ans, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
// @lc code=end

