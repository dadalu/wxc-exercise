package leetcode.editor.cn;
//三维形体的表面积
//给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。 
//
// 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。 
//
// 请你返回最终这些形体的总表面积。 
//
// 注意：每个形体的底面也需要计入表面积中。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：grid = [[2]]
//输出：10
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2],[3,4]]
//输出：34
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0],[0,2]]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：32
// 
//
// 示例 5： 
//
// 
//输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数组 数学 矩阵 👍 151 👎 0

public class SurfaceAreaOf3dShapes{
    public static void main(String[] args) {
        Solution solution = new SurfaceAreaOf3dShapes().new Solution();
        int[][] arr = {{2,2,2},{2,1,2},{2,2,2}};
        solution.surfaceArea(arr);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j] * 6;
                if (grid[i][j] > 1) {
                    sum -= (grid[i][j] -1)*2;
                }
                if (j + 1 < grid[i].length) {
                    sum -= Math.min(grid[i][j], grid[i][j + 1])*2;
                }
                if (i + 1 < grid.length) {
                    sum -= Math.min(grid[i+1][j], grid[i][j])*2;
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}