package leetcode.editor.cn;
//分割回文串
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 831 👎 0

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("aab"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> retList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0);
        return retList;
    }

    private void dfs(String s, int index) {
        if (index == s.length()) {
            retList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (is(s, index, i)) {
                list.add(s.substring(index, i+1));
                dfs(s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean is(String s,int l, int r) {
        if (l == r) {
            return true;
        }
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}