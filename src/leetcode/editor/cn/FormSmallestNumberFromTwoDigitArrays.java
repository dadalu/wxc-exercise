package leetcode.editor.cn;
//从两个数字数组里生成最小数字
//form-smallest-number-from-two-digit-arrays	
//2605
//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 9 
// 1 <= nums1[i], nums2[i] <= 9 
// 每个数组中，元素 互不相同 。 
// 
//
// 👍 34 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Java：从两个数字数组里生成最小数字
public class FormSmallestNumberFromTwoDigitArrays{
    public static void main(String[] args) {
        Solution solution = new FormSmallestNumberFromTwoDigitArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
            min1 = Math.min(min1, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                return nums2[i];
            }
            min2 = Math.min(min2, nums2[i]);
        }
        return min1<min2?min1*10+min2:min2*10+min1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}