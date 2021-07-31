import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {

    // // Time Limit Exceeded
    // public int coinChange(int[] coins, int amount) {
    //     if(amount == 0) return 0;
    //     if(amount < 0) return -1;

    //     int res = Integer.MAX_VALUE;

    //     for( int coin : coins){
    //         int subproblem = coinChange(coins, amount - coin);
    //         if(subproblem == -1) continue;
    //         res = Math.min(res, subproblem + 1);
    //     }

    //     return  res == Integer.MAX_VALUE ? -1 : res;
    // }

        // // memo
        // int[] memo;
        // int constrains;
        // public int coinChange(int[] coins, int amount) {
        //     memo = new int[amount + 1];
        //     constrains = amount + 1;
        //     Arrays.fill(memo, constrains);

        //     return dp(coins, amount);
        // }
        // private int dp(int[] coins, int amount){
        //     if(amount == 0) 
        //         return 0;
        //     if(amount < 0) 
        //         return -1;

        //     if(memo[amount] != constrains) 
        //         return memo[amount];

        //     int res = Integer.MAX_VALUE;
        //     for(int coin : coins){
        //         int subproblem = dp(coins, amount - coin);
        //         if(subproblem == -1) continue;
        //         res = Math.min(res, subproblem + 1);
        //     }

        //     memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        //     return memo[amount];
        // }

        int constrains;
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            constrains = amount + 1;
            Arrays.fill(dp, constrains);

            //base case
            dp[0] = 0;
            for( int i = 0; i < dp.length; i ++){
                for( int coin : coins){
                    if( i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == constrains ? -1 : dp[amount]);
        }
}
// @lc code=end

