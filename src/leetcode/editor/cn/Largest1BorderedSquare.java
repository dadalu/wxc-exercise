package leetcode.editor.cn;
//最大的以 1 为边界的正方形	
//largest-1-bordered-square	
//1139
//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 208 👎 0

//Java：最大的以 1 为边界的正方形
public class Largest1BorderedSquare{
    public static void main(String[] args) {
        Solution solution = new Largest1BorderedSquare().new Solution();
        int[][] arr = {{1, 1, 0, 0}};
        solution.largest1BorderedSquare(arr);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] left = new int[x + 1][y + 1];
        int[][] up = new int[x + 1][y + 1];
        int max = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (grid[i-1][j-1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int board = Math.min(left[i][j],up[i][j]);
                    while (left[i - board + 1][j] < board || up[i][j - board + 1] < board) {
                        board--;
                    }
                    max = Math.max(board, max);
                }

            }
        }
        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
