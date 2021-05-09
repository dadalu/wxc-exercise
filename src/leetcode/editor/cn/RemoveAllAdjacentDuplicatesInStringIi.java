package leetcode.editor.cn;
//删除字符串中的所有相邻重复项 II
//给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。 
//
// 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。 
//
// 在执行完所有删除操作后，返回最终得到的字符串。 
//
// 本题答案保证唯一。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", k = 2
//输出："abcd"
//解释：没有要删除的内容。 
//
// 示例 2： 
//
// 输入：s = "deeedbbcccbdaa", k = 3
//输出："aa"
//解释： 
//先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
//再删除 "bbb"，得到 "dddaa"
//最后删除 "ddd"，得到 "aa" 
//
// 示例 3： 
//
// 输入：s = "pbbcggttciiippooaais", k = 2
//输出："ps"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 2 <= k <= 10^4 
// s 中只含有小写英文字母。 
// 
// Related Topics 栈 
// 👍 85 👎 0

import java.util.ArrayList;
import java.util.List;

public class RemoveAllAdjacentDuplicatesInStringIi{
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInStringIi().new Solution();
        String s = "abcd";
        solution.removeDuplicates(s, 2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s, int k) {
        List<Character> characters = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characters.add(c);
            if (list.isEmpty()) {
                list.add(1);
                continue;
            } else {
                char pre = characters.get(characters.size()-2);
                if (pre == c) {
                    list.add(list.remove(list.size() - 1)+1);
                    if (list.get(list.size() - 1) == k) {
                        int count = k;
                        list.remove(list.size() - 1);
                        while (count > 0) {
                            characters.remove(characters.size() - 1);
                            count--;
                        }
                    }
                } else {
                    list.add(1);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < characters.size(); i++) {
            sb.append(characters.get(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}