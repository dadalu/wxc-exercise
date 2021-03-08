//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int max = 1;
            int begin = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int i = 1; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if(s.charAt(i)!=s.charAt(j)){
                        dp[i][j]=false;
                    }else{
                        if(i-j<3){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i-1][j+1];
                        }
                        if(dp[i][j]&&i-j+1>max){
                            begin = j;
                            max = i-j+1;
                        }
                    }
                }

            }
            return s.substring(begin,begin+max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
