package leetcode.editor.cn;
//判断矩阵经轮转后是否一致
//给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 
//target 一致，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//输出：true
//解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//输出：false
//解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
// 
//
// 示例 3： 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//输出：true
//解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
// 
//
// 
//
// 提示： 
//
// 
// n == mat.length == target.length 
// n == mat[i].length == target[i].length 
// 1 <= n <= 10 
// mat[i][j] 和 target[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 矩阵 
// 👍 8 👎 0

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation{
    public static void main(String[] args) {
        Solution solution = new DetermineWhetherMatrixCanBeObtainedByRotation().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < (n+1)/2; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n-1-i][n - 1 - j];
                    mat[n-1-i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }

            }
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}