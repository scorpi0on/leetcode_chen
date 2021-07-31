/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode s, t, prev;

    public void recoverTree(TreeNode root) {
        // leftchild < root < rightchild
        //ascend
        inorderTraversal(root);
        findTwoSwapeNums(s, t);
    }

    public void inorderTraversal(TreeNode curr){
        if(curr == null) return ;

        inorderTraversal(curr.left);


        if(prev != null && prev.val > curr.val){
            s = (s == null) ? prev : s;
            t = curr;
        }
        prev = curr;

        inorderTraversal(curr.right);
    }

    public void findTwoSwapeNums(TreeNode s, TreeNode t){
        int temp = s.val;
        s.val = t.val;
        t.val = temp;
    }
}
// @lc code=end

