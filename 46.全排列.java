import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        
        backtrack(nums, track);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track){
        if( track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for(int num : nums){
            if(track.contains(num)) continue;

            track.add(num);

            backtrack(nums, track);

            track.removeLast();
        }
    }
}
// @lc code=end

