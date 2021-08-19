package leetcode.editor.cn;
//递归乘法
//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 位运算 递归 数学 
// 👍 45 👎 0

public class RecursiveMulitplyLcci{
    public static void main(String[] args) {
        Solution solution = new RecursiveMulitplyLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int multiply(int A, int B) {
        if (B > A) {
            return cal(B, A);
        }
        return cal(A,B);
    }
    public int cal(int max, int min) {
        int ans;
        if (min == 1) {
            return max;
        }
        if (min == 2) {
            return max + max;
        }
        if (min % 2 == 1) {
            return max+(cal(max, min / 2) << 1);
        } else {
            return cal(max, min / 2) << 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}