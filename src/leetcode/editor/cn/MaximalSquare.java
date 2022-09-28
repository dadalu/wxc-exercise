package leetcode.editor.cn;
//最大正方形
//maximal-square	
//221
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1277 👎 0

import java.util.Arrays;

//Java：最大正方形
public class MaximalSquare{
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        // TO TEST
        System.out.println(solution.maximalSquare(arr));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;


                    if (i - 1 >= 0 && j - 1 >= 0) {
                        min = Math.min(min, dp[i-1][j - 1]);
                        min = Math.min(min, dp[i - 1][j]);
                        min = Math.min(min, dp[i][j - 1]);
                    } else {
                        min = 0;
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}