package leetcode.editor.cn;
//汇总区间
//summary-ranges	
//228
//给定一个 无重复元素 的 有序 整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// 👍 314 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：汇总区间
public class SummaryRanges{
    public static void main(String[] args) {
        Solution solution = new SummaryRanges().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<>();
        if (nums.length == 0) {
            return rst;
        }
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (r <= nums.length) {
            if (r == nums.length) {
                if (l + cur == nums.length - 1) {
                    if (cur!=0) {
                        sb.append("->");
                        sb.append(nums[l + cur]);
                    }
                    rst.add(sb.toString());
                    break;
                }
            }
            if (l == r) {
                sb.append(nums[l]);
                r++;
                continue;
            }
            if (nums[l + cur] + 1 == nums[r]) {
                r++;
                cur++;
            } else {
                if (cur != 0) {
                    sb.append("->");
                    sb.append(nums[l + cur]);
                    rst.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    rst.add(sb.toString());
                    sb = new StringBuilder();
                }
                cur = 0;
                l = r;
            }
        }

        return rst;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}