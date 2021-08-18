package leetcode.editor.cn;
//哪种连续子字符串更长
//给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 fa
//lse 。 
//
// 
// 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。 
// 
//
// 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1101"
//输出：true
//解释：
//由 1 组成的最长连续子字符串的长度是 2："1101"
//由 0 组成的最长连续子字符串的长度是 1："1101"
//由 1 组成的子字符串更长，故返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：s = "111000"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 3："111000"
//由 0 组成的最长连续子字符串的长度是 3："111000"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 示例 3： 
//
// 
//输入：s = "110100010"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 2："110100010"
//由 0 组成的最长连续子字符串的长度是 3："110100010"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 不是 '0' 就是 '1' 
// 
// Related Topics 字符串 
// 👍 10 👎 0

public class LongerContiguousSegmentsOfOnesThanZeros{
    public static void main(String[] args) {
        Solution solution = new LongerContiguousSegmentsOfOnesThanZeros().new Solution();
        solution.checkZeroOnes("111000");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkZeroOnes(String s) {
        int zeroLength = 0;
        int oneLength = 0;
        int maxO = 0;
        int maxZ = 0;
        char pre = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (pre == ' ') {
                if (s.charAt(i) == '0') {
                    zeroLength++;
                } else {
                    oneLength++;
                }
            }else  if (s.charAt(i) == '0') {
                zeroLength++;
                if (pre != '0') {
                    maxO = Math.max(oneLength,maxO);
                    oneLength = 0;
                }
            }else if (s.charAt(i) == '1') {
                oneLength++;
                if (pre != '1') {
                    maxZ = Math.max(maxZ,zeroLength);
                    zeroLength = 0;
                }
            }
            pre = s.charAt(i);
        }
        maxO = Math.max(oneLength,maxO);
        maxZ = Math.max(maxZ,zeroLength);
        return maxO>maxZ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}