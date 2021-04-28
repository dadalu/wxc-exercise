package leetcode.editor.cn;
//132 模式
//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 505 👎 0

import java.util.ArrayList;
import java.util.List;

public class One32Pattern{
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
        int[] arr = {1, 4, 0, -1, -2, -3, -1, -2};
        solution.find132pattern(arr);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (test(nums,i)) {
                return true;
            }
        }
        return false;
    }

    private boolean test(int[] nums,int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = k; i < nums.length; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            } else if(list.get(list.size()-1)>nums[i]){
                if (list.size() == 1) {
                    list.remove(list.size() - 1);
                    list.add(nums[i]);
                } else if (list.get(0) < nums[i]) {
                    return true;
                }
            } else if (list.get(list.size() - 1) < nums[i]) {
                if (list.size() == 1) {
                    list.add(nums[i]);
                } else if (list.get(0) < nums[i]) {
                    list.remove(list.size() - 1);
                    list.add(nums[i]);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}