package leetcode.editor.cn;
//统计参与通信的服务器
//count-servers-that-communicate	
//1267
//这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。 
//
// 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。 
//
// 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,0],[0,1]]
//输出：0
//解释：没有一台服务器能与其他服务器进行通信。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,0],[1,1]]
//输出：3
//解释：所有这些服务器都至少可以与一台别的服务器进行通信。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
//输出：4
//解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 250 
// 1 <= n <= 250 
// grid[i][j] == 0 or 1 
// 
//
// 👍 89 👎 0

//Java：统计参与通信的服务器
public class CountServersThatCommunicate{
    public static void main(String[] args) {
        Solution solution = new CountServersThatCommunicate().new Solution();
        int[][] grid = new int[][]{{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        solution.countServers(grid);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countServers(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int num = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1) {
                    num++;
                }
            }
            if (num > 1) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]==1) {
                        arr[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int num = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i]==1) {
                    num++;
                }
            }
            if (num > 1) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[j][i]==1) {
                        arr[j][i] = 2;
                    }
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]==2) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}