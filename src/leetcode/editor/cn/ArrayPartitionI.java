package leetcode.editor.cn;
//数组拆分 I
//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 
//的 min(ai, bi) 总和最大。 
//
// 示例 1: 
//
// 
//输入: [1,4,3,2]
//
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
// 
//
// 提示: 
//
// 
// n 是正整数,范围在 [1, 10000]. 
// 数组中的元素范围在 [-10000, 10000]. 
// 
// Related Topics 数组 
// 👍 190 👎 0

import java.util.Arrays;

public class ArrayPartitionI{
    public static void main(String[] args) {
        Solution solution = new ArrayPartitionI().new Solution();
        int[] arr ={3,1,2,4};
        System.out.println(solution.arrayPairSum(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length==2)return Math.min(nums[0],nums[1]);
        Arrays.sort(nums);
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                min+=nums[i];
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}