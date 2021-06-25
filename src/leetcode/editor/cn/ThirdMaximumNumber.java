package leetcode.editor.cn;
//第三大的数
//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 排序 
// 👍 229 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ThirdMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        int[] arr = {-2147483648,1,1};
        solution.thirdMax(arr);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.equals(o2)?0:((long)o2-(long)o1)>0L?1:-1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (!queue.contains(nums[i])) {
                queue.add(nums[i]);
            }
        }
        if (queue.size() < 3) {
            return queue.peek();
        }
        for (int i = 0; i < 2; i++) {
            queue.remove();
        }
        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}