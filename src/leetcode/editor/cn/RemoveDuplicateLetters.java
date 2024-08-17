package leetcode.editor.cn;
//去除重复字母
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
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
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 492 👎 0

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateLetters{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Character> list = new ArrayList<>();
    List<Character> charList = new ArrayList<>();
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charList.add(chars[i]);
        }
        while (!charList.isEmpty()) {
            char c = charList.remove(0);
            if (list.contains(c)) {
                continue;
            }
            while (list.size() > 0) {
                char c1 = list.get(list.size() - 1);
                if (c1 > c && charList.contains(c1)) {
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
            list.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}