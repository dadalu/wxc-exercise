package leetcode.editor.cn;
//买卖股票的最佳时机含冷冻期
//best-time-to-buy-and-sell-stock-with-cooldown	
//309
//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// 👍 1720 👎 0

public class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] prices;
//递归超时
//        public int maxProfit(int[] prices) {
//            this.prices = prices;
//            return Math.max(option(0, 0, 0, 0), option(-1, 0, 0, 0));
//        }
//
//        public int option(int option, int sum, int index, int buy) {
//            if (index == prices.length) {
//                return sum;
//            }
//            if (option == 0) {
//                if (buy == 1) {
//                    return Math.max(option(0, sum, index + 1, 1), option(1, sum, index + 1, 0));
//                } else {
//                    return Math.max(option(0, sum, index + 1, 0), option(-1, sum, index + 1, 0));
//                }
//            } else if (option == 1) {
//                return option(0, sum + prices[index], index + 1, 0);
//            } else {
//                return Math.max(option(0, sum - prices[index], index + 1, 1), option(1, sum - prices[index], index + 1, 1));
//            }
//        }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}