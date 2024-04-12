package leetcode.editor.cn;
//找到冠军 I
//find-champion-i	
//2923
//一场比赛中共有 n 支队伍，按从 0 到 n - 1 编号。 
//
// 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, 
//j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。 
//
// 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。 
//
// 返回这场比赛中将会成为冠军的队伍。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[0,0]]
//输出：0
//解释：比赛中有两支队伍。
//grid[0][1] == 1 表示 0 队比 1 队强。所以 0 队是冠军。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,1],[1,0,1],[0,0,0]]
//输出：1
//解释：比赛中有三支队伍。
//grid[1][0] == 1 表示 1 队比 0 队强。
//grid[1][2] == 1 表示 1 队比 2 队强。
//所以 1 队是冠军。
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 的值为 0 或 1
// 
// 对于所有 i， grid[i][i] 等于 0. 
// 对于满足 i != j 的所有 i, j ，grid[i][j] != grid[j][i] 均成立 
// 生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强 
// 
//
// 👍 25 👎 0

import java.util.Arrays;

//Java：找到冠军 I
public class FindChampionI{
    public static void main(String[] args) {
        Solution solution = new FindChampionI().new Solution();
        // TO TEST
        int[][] arr = {{0, 1}, {0, 0}};
        solution.findChampion(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findChampion(int[][] grid) {
        Integer[] arr = new Integer[grid.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (grid[o1][o2] == 1) {
                return -1;
            } else if (grid[o2][o1] == 1) {
                return 1;
            } else {
                return 0;
            }
        });
        return arr[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}