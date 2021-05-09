package leetcode.editor.cn;
//表现良好的最长时间段
//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10000 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 
// 👍 136 👎 0

import java.util.*;

public class LongestWellPerformingInterval{
    public static void main(String[] args) {
        Solution solution = new LongestWellPerformingInterval().new Solution();
        int[] arr = {9,9,6,0,6,6,9};
        solution.longestWPI(arr);
    }

//leetcode submit region begin(Prohibit modification and deletion)
// 输入：hours = [9,9,6,0,6,6,9]
class Solution {
    public int longestWPI(int[] hours) {
        //转换为只包含1，-1的数组 [1,1,-1,-1,-1,1]
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }

        //计算前缀数组，长度+1，首位为0; [0,1,2,1,0,-1,-2,-1]
        int[] prefixArr = new int[hours.length + 1];
        for (int i = 1; i <= hours.length; i++) {
            prefixArr[i] = prefixArr[i - 1] + hours[i-1];
        }
        int max = 0;
        //使用list作为栈，当前遍历数组下标为0，
        //或者当前数组元素小于栈顶元素为下表的元素值，则将当前下表压入栈中
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < prefixArr.length; i++) {
            if (i==0||prefixArr[list.get(list.size()-1)] > prefixArr[i]) {
                list.add(i);
            }
        }
        while (!list.isEmpty()) {
            //倒序遍历prefix数组
            int i = list.remove(list.size() - 1);
            for (int j = prefixArr.length-1; j >i; j--) {
                if (prefixArr[j] > prefixArr[i]) {
                    max = Math.max(j - i, max);
                    break;
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}