import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import jdk.nashorn.internal.ir.IfNode;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> deads = new HashSet<>();
        for(String deadend : deadends){
            deads.add(deadend);
        }

        if(deads.contains("0000")) return -1;

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");

        while(!queue.isEmpty()){
            ++step;
            int size = queue.size();
            for(int i=0; i<size; i++){
                String status = queue.poll();
                for(String nextStatus:get(status)){
                    if(!seen.contains(nextStatus) && !deads.contains(nextStatus)){
                        if(nextStatus.equals(target)) return step;
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> get(String status){
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

    private char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    private char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

}
// @lc code=end

