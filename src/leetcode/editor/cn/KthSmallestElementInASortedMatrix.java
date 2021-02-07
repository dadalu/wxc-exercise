package leetcode.editor.cn;
//有序矩阵中第K小的元素
//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找 
// 👍 529 👎 0

public class KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length-1][matrix.length-1];
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(matrix, mid, k, matrix.length)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[][] matrix,int mid,int k,int n) {
        int i = n - 1, j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (mid >= matrix[i][j]) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}