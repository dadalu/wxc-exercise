package leetcode.editor.cn;
//分割数组为连续子序列
//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10000 
// 
// Related Topics 堆 贪心算法 
// 👍 280 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp,new PriorityQueue<>());
            }
            if (map.containsKey(temp - 1)) {
                PriorityQueue<Integer> preQueue = map.get(temp - 1);
                int cur = preQueue.poll() + 1;
                if (preQueue.isEmpty()) {
                    map.remove(temp - 1);
                }
                map.get(temp).offer(cur);
            } else {
                map.get(temp).offer(1);
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry:map.entrySet()) {
            PriorityQueue<Integer> queue = entry.getValue();
            while (!queue.isEmpty()) {
                if (queue.poll() < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}