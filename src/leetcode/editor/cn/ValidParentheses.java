//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class  ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        boolean b = solution.isValid("[{()}]");
        System.out.println(b);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            List<Character> list = new ArrayList();
            if ("".equals(s)) return true;
            if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    list.add(c);
                } else if (c == '}' && list.size() != 0 && list.get(list.size() - 1) == '{') {
                    list.remove(list.size() - 1);
                } else if (c == ')' && list.size() != 0 && list.get(list.size() - 1) == '(') {
                    list.remove(list.size() - 1);
                } else if (c == ']' && list.size() != 0 && list.get(list.size() - 1) == '[') {
                    list.remove(list.size() - 1);
                } else {
                    return false;
                }
            }
            if (list.size() == 0) {
                return true;
            }
            return false;
        }
    }
}
