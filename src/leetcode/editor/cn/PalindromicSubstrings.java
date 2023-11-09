package leetcode.editor.cn;
//回文子串
//palindromic-substrings	
//647
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 👍 1255 👎 0

//Java：回文子串
public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        // TO TEST
        solution.countSubstrings("aaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            boolean pre = dp[i][i];
            while (pre&&0 <= l && r < s.length()) {
                dp[l][r] = s.charAt(l)==s.charAt(r);
                pre = dp[l][r];
                l--;
                r++;
            }
            if (i + 1 < s.length()) {
                pre = dp[i][i + 1];
                l = i - 1;
                r = i + 2;
                while (pre&&0 <= l && r < s.length()) {
                    dp[l][r] = s.charAt(l)==s.charAt(r);
                    pre = dp[l][r];
                    l--;
                    r++;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}