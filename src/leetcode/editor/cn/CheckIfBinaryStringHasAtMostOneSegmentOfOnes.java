package leetcode.editor.cn;
//检查二进制字符串字段
//给你一个二进制字符串 s ，该字符串 不含前导零 。 
//
// 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1001"
//输出：false
//解释：字符串中的 1 没有形成一个连续字段。
// 
//
// 示例 2： 
//
// 
//输入：s = "110"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 为 '0' 或 '1' 
// s[0] 为 '1' 
// 
// Related Topics 贪心算法 
// 👍 6 👎 0

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes{
    public static void main(String[] args) {
        Solution solution = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (chars[i] == '1'&&chars[i+1]=='0') {
                count++;
            }
            if (chars[i] == '0'&&chars[i+1]=='1') {
                count++;
            }
        }
        return count<=1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}