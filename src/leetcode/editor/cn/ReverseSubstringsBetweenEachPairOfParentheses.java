package leetcode.editor.cn;
//反转每对括号间的子串
//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 74 👎 0

import java.util.ArrayList;
import java.util.List;

public class ReverseSubstringsBetweenEachPairOfParentheses{
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseParentheses(String s) {
        List<Character> list = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (')' != s.charAt(i)) {
                list.add(s.charAt(i));
            } else {
                while (list.get(list.size() - 1) != '(') {
                    char c = list.remove(list.size() - 1);
                    temp.add(c);
                }
                list.remove(list.size() - 1);
                while (!temp.isEmpty()) {
                    char c = temp.remove(0);
                    list.add(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}