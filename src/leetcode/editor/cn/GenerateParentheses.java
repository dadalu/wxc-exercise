package leetcode.editor.cn;
//括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2024 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list = new ArrayList<>();
    int size;
    public List<String> generateParenthesis(int n) {
        size = 2 * n;
        dfs(new StringBuilder(),size);
        return list;
    }
    public void dfs(StringBuilder s,Integer n) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                count++;
            }
        }
        if (count > s.length() - count) {
            return;
        }
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
        }

        if (count > size/2) {
            return;
        }

        if (n == 0) {
            list.add(s.toString());
        }
        StringBuilder sb = new StringBuilder(s);
        sb.append("(");
        dfs(sb,n-1);
        sb = new StringBuilder(s);
        sb.append(")");
        dfs(sb,n-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}