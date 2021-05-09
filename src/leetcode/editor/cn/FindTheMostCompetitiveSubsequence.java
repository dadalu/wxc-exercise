package leetcode.editor.cn;
//找出最具竞争力的子序列
//给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。 
//
// 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。 
//
// 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 
//。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,5,2,6], k = 2
//输出：[2,6]
//解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,4,3,3,5,4,9,6], k = 4
//输出：[2,3,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 1 <= k <= nums.length 
// 
// Related Topics 栈 堆 贪心算法 队列 
// 👍 57 👎 0

import java.util.*;

public class FindTheMostCompetitiveSubsequence{
    public static void main(String[] args) {
        Solution solution = new FindTheMostCompetitiveSubsequence().new Solution();
        //int[] arr = {84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71};
        int[] arr = {3,5,2,6};
        int[]ret = solution.mostCompetitive(arr, 2);
        System.out.println(ret);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            } else {
                int pre = list.get(list.size() - 1);
                while (nums[i] < pre) {
                    if (nums.length - i - 1 + list.size() >= k) {
                        list.remove(list.size() - 1);
                        if (list.isEmpty()) {
                            break;
                        }
                        pre = list.get(list.size() - 1);
                    } else {
                        break;
                    }
                }
                list.add(nums[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}