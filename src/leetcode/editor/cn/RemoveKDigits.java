package leetcode.editor.cn;
//移掉K位数字
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 559 👎 0

import java.util.ArrayList;
import java.util.List;

public class RemoveKDigits{
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        solution.removeKdigits("10001", 4);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return String.valueOf(0);
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (list.size() == 0) {
                if (c != '0') {
                    list.add(c);
                }
            } else {
                while (k > 0 &&!list.isEmpty()&& list.get(list.size() - 1) > c) {
                    list.remove(list.size() - 1);
                    k--;
                }
                list.add(c);
            }
        }
        for (int i = 0; i < k; i++) {
            if (list.isEmpty()) {
                break;
            }
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            if (flag && list.get(i) == '0') {
                continue;
            } else {
                flag = false;
                sb.append(list.get(i));

            }
        }
        return sb.toString().equals("")?"0":sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}