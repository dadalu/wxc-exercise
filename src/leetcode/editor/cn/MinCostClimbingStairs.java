package leetcode.editor.cn;
//使用最小花费爬楼梯
//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。 
//
// 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。 
//
// 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。 
//
// 示例 1: 
//
// 输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
// 
//
// 示例 2: 
//
// 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出: 6
//解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
// 
//
// 注意： 
//
// 
// cost 的长度将会在 [2, 1000]。 
// 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。 
// 
// Related Topics 数组 动态规划 
// 👍 392 👎 0

public class MinCostClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
        int[] arr = {0,0,1,1};
        int[] arr1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //System.out.println(solution.minCostClimbingStairs(arr));
        System.out.println(solution.minCostClimbingStairs(arr1));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = cost[0];
        dp[1] = cost[1];
        int index = cost.length-1;
        dp[index]=Math.min(minCost(cost,index-2)+cost[index],minCost(cost,index-1));

        return dp[index];
    }
    int minCost(int[] cost,int index){
        if(dp[index]==Integer.MAX_VALUE){
            dp[index]=Math.min(minCost(cost,index-1)+cost[index],minCost(cost,index-2)+cost[index]);
        }
        return dp[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}