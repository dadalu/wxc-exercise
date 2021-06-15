package leetcode.editor.cn;
//存在重复元素 III
//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// Related Topics 排序 Ordered Map 
// 👍 465 👎 0

import java.util.*;

public class ContainsDuplicateIii{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //滑动窗口解法
    /*public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceil = set.ceiling((long) nums[i] - (long) t);
            if (ceil!=null&&ceil<=nums[i]+(long)t) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }*/
    //桶排序解法
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < n; i++) {
            long sortId;
            if (nums[i] >= 0) {
                sortId = nums[i] / w;
            } else {
                sortId = (nums[i]+1)/w - 1;
            }
            if (map.containsKey(sortId)) {
                return true;
            }
            if (map.containsKey(sortId - 1) && Math.abs(map.get(sortId - 1) - nums[i])<w) {
                return true;
            }
            if (map.containsKey(sortId + 1) && Math.abs(map.get(sortId + 1) - nums[i])<w) {
                return true;
            }
            map.put(sortId, (long)nums[i]);
            if (map.size() > k) {
                long remId;
                if (nums[i-k] >= 0) {
                    remId = nums[i-k] / w;
                } else {
                    remId = (nums[i-k]+1)/w - 1;
                }
                map.remove(remId);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}