package leetcode.editor.cn;
//任意子数组和的绝对值的最大值
//maximum-absolute-sum-of-any-subarray	
//1749
//给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
//numsl + numsl+1 + ... + numsr-1 + numsr) 。 
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。 
//
// abs(x) 定义如下：
//
// 
// 如果 x 是负整数，那么 abs(x) = -x 。 
// 如果 x 是非负整数，那么 abs(x) = x 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 118 👎 0

//Java：任意子数组和的绝对值的最大值
public class MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumAbsoluteSumOfAnySubarray().new Solution();
        // TO TEST
        int[] arr = {-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        solution.maxAbsoluteSum(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int maxP = 0, maxN = 0, sumP = 0, sumN = 0;
            for (int i = 0; i < nums.length; i++) {
                maxP = Math.max(maxP, sumP + nums[i]);
                sumP = Math.max(0, sumP + nums[i]);
                maxN = Math.min(maxN, sumN + nums[i]);
                sumN = Math.min(0, sumN + nums[i]);
            }
            return maxP > -maxN ? maxP : -maxN;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}