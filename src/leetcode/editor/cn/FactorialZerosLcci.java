package leetcode.editor.cn;
//阶乘尾数
//设计一个算法，算出 n 阶乘有多少个尾随零。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// 👍 48 👎 0

public class FactorialZerosLcci{
    public static void main(String[] args) {
        Solution solution = new FactorialZerosLcci().new Solution();
        System.out.println(solution.trailingZeroes(105));
    }
// Related Topics 数学

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}