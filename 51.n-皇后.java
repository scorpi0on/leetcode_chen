import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<StringBuilder> track = new ArrayList<>();    
        //初始化棋盘
        for(int i = 0; i < n; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++){
                str.append('.');
            }
            track.add(str);
        }
        backtrace(track, 0);
        return res;
    }
    
    private void backtrace(List<StringBuilder> track, int row){
        if(track.size() == row) {
            ArrayList<String> temp = new ArrayList<>();
            //讲StringBuilder类转化为String类
            for(int i = 0; i < track.size(); i++){
                temp.add(track.get(i).toString());                
            }
            res.add(temp);
            return;
        };

        int n = track.get(row).length();
        for(int col = 0; col < n; col++){
            if(!isValid(track,row,col)) continue;
            //做选择
            track.get(row).setCharAt(col,'Q');
            //进入下一行放皇后
            backtrace(track, row+1);
            //撤销选择
            track.get(row).setCharAt(col,'.');
        }
    }

    private boolean isValid(List<StringBuilder> track, int row, int col){
        int n = track.size();
        //rowcheck
        for(int i = 0; i < n; i++){
            if(track.get(i).charAt(col) == 'Q') 
            return false;
        }
        //rightup
        for(int i = row-1, j = col+1; i>=0 && j <n; i--,j++){
            if(track.get(i).charAt(j) == 'Q') 
                return false;
        }
        //leftup
        for(int i = row-1, j = col-1; i>=0 && j >=0; i--,j--){
            if(track.get(i).charAt(j) == 'Q') 
                return false;
        }

        return true;
    }
}
// @lc code=end

