package leetcode.editor.cn;
//最大交换
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 贪心 数学 
// 👍 181 👎 0

import java.util.PriorityQueue;

public class MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(98368));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int i = 0; i < sb.length(); i++) {
            int pre = sb.charAt(i) - '0';
            priorityQueue.add(pre);
        }
        Integer l=null,r = null;
        for (int i = 0; i < sb.length(); i++) {
            int temp = priorityQueue.poll();
            if (sb.charAt(i) == temp+'0') {
                continue;
            }
            l = sb.charAt(i)-'0';
            r = temp;
            sb.delete(i,i+1);
            sb.insert(i,r);
            break;
        }
        if (r == null || l == null) {
            return num;
        }
        for (int i = sb.length()-1; i >0; i--) {
            if (sb.charAt(i) == r+'0') {
                sb.delete(i, i+1);
                sb.insert(i,l);
                break;
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}