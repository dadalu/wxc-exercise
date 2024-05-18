package leetcode.editor.cn;
//搜索二维矩阵 II
//search-a-2d-matrix-ii	
//240
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// 👍 1463 👎 0

public class SearchA2dMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        // TO TEST
        int[][] arr = {{1, 1}};
        solution.searchMatrix(arr, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] matrix;
        int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int l = matrix[0].length;
        int x = l - 1,y = 0;
        while (x>=0&&y<r) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }
        }
        if (y < r) {
            for (int i = y; i < matrix.length; i++) {
                if (matrix[i][0] == target) {
                    return true;
                } else if (matrix[i][0] > target) {
                    return false;
                }
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}