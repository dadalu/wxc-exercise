package leetcode.editor.cn;
//重复的子字符串
//repeated-substring-pattern	
//459
//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 👍 1154 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：重复的子字符串
public class RepeatedSubstringPattern{
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        solution.repeatedSubstringPattern("abbab");
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int l = 0, r = 1;
        List<String> list = new ArrayList<>();
        while (r<=s.length()/2) {
            if (s.charAt(l) == s.charAt(r)) {
                list.add(s.substring(0, r));
            }
            r++;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (s.length() % str.length() == 0) {
                int n = s.length() / str.length();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(str);
                }
                if (s.contentEquals(sb)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}