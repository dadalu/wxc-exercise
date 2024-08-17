package leetcode.editor.cn;
//最长特殊序列 II
//longest-uncommon-subsequence-ii	
//522
//给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
//
// 👍 224 👎 0

public class LongestUncommonSubsequenceIi{
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
        String[] strs = {"aabbcc","aabbcc","c"};
        solution.findLUSlength(strs);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean check = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j&&isSubsequence(strs[i],strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }
    public boolean isSubsequence(String s, String t) {
        int p1 = 0,p2 =0;
        while (p1 < s.length()&&p2<t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}