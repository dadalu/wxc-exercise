package leetcode.editor.cn;
//统计移除递增子数组的数目 I
//count-the-number-of-incremovable-subarrays-i	
//2970
//给你一个下标从 0 开始的 正 整数数组 nums 。 
//
// 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7] 
//中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。 
//
// 请你返回 nums 中 移除递增 子数组的总数目。 
//
// 注意 ，剩余元素为空的数组也视为是递增的。 
//
// 子数组 指的是一个数组中一段连续的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：10
//解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和 
//[1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [6,5,7,8]
//输出：7
//解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
//nums 中只有这 7 个移除递增子数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [8,7,6,6]
//输出：3
//解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后 
//nums 变为 [6,6] ，它不是严格递增的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 1 <= nums[i] <= 50 
// 
//
// 👍 35 👎 0

public class CountTheNumberOfIncremovableSubarraysI {
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfIncremovableSubarraysI().new Solution();
        // TO TEST
        int[] arr = {6,5,7,8};
        solution.incremovableSubarrayCount(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int incremovableSubarrayCount(int[] nums) {
            int res = 0;
            int l = 1;
            while (l < nums.length - 1) {
                if (nums[l-1] < nums[l]) {
                    l++;
                } else {
                    break;
                }
            }
            res += l + (l < nums.length ? 1 : 0);
            for (int r = nums.length - 2; r >= 0; r--) {
                while (l > 0) {
                    if (nums[l - 1] >= nums[r + 1]) {
                        l--;
                    } else {
                        break;
                    }
                }
                res += l + (l <= r ? 1 : 0);
                if (nums[r] >= nums[r + 1]) {
                    break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
/**
 * 为了方便描述，我们用 [l,r] 表示 nums 中下标范围在 [l,r] 的子数组。
 *
 * 容易观察到，若 [l,r] 是移除递增子数组，则 [l−1,r] 一定也是移除递增子数组。这样一来，对于某个确定的 r，只需要找到最大的 l 使 [l,r] 为移除递增子数组，就可以快速的统计答案。
 *
 * 更进一步，随着 r 递减，这样的 l 不可能递增。因为要满足方法一中的条件三：若 nums[l] 左侧有元素并且 nums[r] 右侧有元素，并且 nums[l]<nums[r+1]。如果 nums[r] 减小，则 nums[l] 不可能增加。
 *
 * 因此，由于 l 和 r 存在单调变化的规律，我们可以使用双指针算法快速求解。
 *
 * 我们首先找到最大的 l，使得 [0,l−1] 是单调递增子数组。这样一来，如下子数组都是移除递增子数组：
 *
 * [l−1,n−1]
 * [l−2,n−1]
 * ⋯
 * [0,n−1]
 * 共 l 个，若 l<n，那么 [l,n−1] 也是移除递增子数组。
 *
 * 以此为起点，我们从 n−2（n−1 的情况已计算过） 到 0 去枚举 r，并且需要时刻满足 [r+1,n−1] 内的元素单调递增。若 nums[l−1]>=nums[r+1]，则不断的将 l 减去 1, 直到条件不被满足。此时，如下子数组都是移除递增子数组：
 *
 * [l−1,r]
 * [l−2,r]
 * ⋯
 * [0,r]
 * l>=r+1
 * 共 l 个，若 l≤r，（说明r>r+1,到此结束了）那么 [l,r] 也是移除递增子数组
 */