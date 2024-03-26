package leetcode.editor.cn;
//有序数组的平方
//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 175 👎 0

import java.util.Arrays;

public class SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        int[] arr = {-4, -1, 0, 3, 10};
        solution.sortedSquares(arr);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        Arrays.fill(ret, -1);
        int l = 0, r = A.length - 1;
        int i = A.length - 1;
        while (l <= r) {
            int pl = A[l] * A[l];
            int pr = A[r] * A[r];
            if (pl >= pr) {
                ret[i] = pl;
                l++;
            } else {
                ret[i] = pr;
                r--;
            }
            i--;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}