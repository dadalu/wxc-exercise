package leetcode.editor.cn;
//不同字符的最小子序列
//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 95 👎 0

import java.util.ArrayList;
import java.util.List;

public class SmallestSubsequenceOfDistinctCharacters{
    public static void main(String[] args) {
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Character> retList = new ArrayList();
    List<Character> orgList = new ArrayList();
    public String smallestSubsequence(String s) {
        for (int i = 0; i < s.length(); i++) {
            orgList.add(s.charAt(i));
        }
        while (!orgList.isEmpty()) {
            char c = orgList.remove(0);
            if (retList.contains(c)) {
                continue;
            }
            char c1;
            while (!retList.isEmpty()) {
                c1 = retList.get(retList.size() - 1);
                if (c1 > c && orgList.contains(c1)) {
                    retList.remove(retList.size() - 1);
                } else {
                    break;
                }
            }
            retList.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < retList.size(); i++) {
            sb.append(retList.get(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}