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
        for (int i = 0; i < ret.length; i++) {
            ret[i]=-1;
        }
        for (int i = 0; i < A.length; i++) {
            int p = A[i]*A[i];
            for (int j = 0; j <= i; j++) {
                if (p >= ret[j] && ret[j] != -1) {
                    continue;
                } else {
                    for (int k = i; k >j&&k<A.length; k--) {
                        ret[k] = ret[k - 1];
                    }
                    ret[j] = p;
                    break;
                }

            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}