import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.IntFunction;

import jdk.nashorn.internal.ir.IfNode;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for(String deadend : deadends){
            deads.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                if(deads.contains(curr)) continue;
                if(curr.equals(target)) return step;

                for(int j = 0; j < 4; j++){
                    String up = plusOne(curr, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(curr, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private String plusOne(String s, int j){
        char[] chs = s.toCharArray();
        if(chs[j] == '9'){
            chs[j] = '0';
        }else{
            chs[j] += 1;
        }

        return new String(chs);
    }

    private String minusOne(String s, int j){
        char[] chs = s.toCharArray();
        if(chs[j] == '0'){
            chs[j] = '9';
        }else{
            chs[j] -= 1;
        }

        return new String(chs);
    }


}
// @lc code=end

