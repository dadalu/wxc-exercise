package leetcode.editor.cn;
//三步问题
//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 61 👎 0

public class ThreeStepsProblemLcci{
    public static void main(String[] args) {
        Solution solution = new ThreeStepsProblemLcci().new Solution();
        solution.waysToStep(61);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007 +dp[i-3];
            dp[i] %= 1000000007;
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}