package leetcode.editor.cn;
//括号的分数
//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// Related Topics 栈 字符串 
// 👍 205 👎 0

import java.util.ArrayList;
import java.util.List;

public class ScoreOfParentheses{
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
        String s = "(()(()))";
        solution.scoreOfParentheses(s);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String S) {
        int ret = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                char c;
                int temp = 0;
                while ((c = list.remove(list.size() - 1)) != '(') {
                    temp += c-'0';
                }
                if (temp == 0) {
                    list.add('1');
                } else {
                    temp *= 2;
                    while (temp > 9) {
                        list.add('9');
                        temp-=9;
                    }
                    list.add((char)(temp+'0'));
                }
            } else {
                list.add(S.charAt(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            ret += list.get(i) - '0';
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}