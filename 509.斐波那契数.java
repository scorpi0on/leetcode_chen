/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {

    // //recursive
    // public int fib(int n) {
    //     if(n == 0) return 0;

    //     if(n == 1) return 1;

    //     return fib(n-1) + fib(n - 2);
    // }

    // //memo
    // public int fib(int n) {
    //     int[] memo = new int[n + 1];
    //     return helper(memo, n);
    // }

    // public int helper(int[] memo, int n){
    //     if(n ==0 || n == 1) return n;
    //     memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
    //     return memo[n];
    // }

    // two variables
    public int fib(int n) {
        //base case
        if(n == 0 || n == 1) return n;

        int prev = 0, curr = 1;
        for(int i=2; i<=n; i++) {
            int sum = curr + prev;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
// @lc code=end

