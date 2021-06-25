package leetcode.editor.cn;
//电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1364 👎 0

import java.util.*;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> set = new ArrayList<>();
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length()==0) {
            return set;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(digits.charAt(i) - '0');
        }

        map.put(2, Arrays.asList(new String[]{"a", "b", "c"}));
        map.put(3, Arrays.asList(new String[]{"d", "e", "f"}));
        map.put(4, Arrays.asList(new String[]{"g", "h", "i"}));
        map.put(5, Arrays.asList(new String[]{"j", "k", "l"}));
        map.put(6, Arrays.asList(new String[]{"m", "n", "o"}));
        map.put(7, Arrays.asList(new String[]{"p", "q", "r", "s"}));
        map.put(8, Arrays.asList(new String[]{"t", "u", "v"}));
        map.put(9, Arrays.asList(new String[]{"w", "x", "y", "z"}));

        serach(new StringBuffer(), list);
        return set;
    }

    public void serach(StringBuffer sb, List<Integer> oriList) {
        List<Integer> list = new ArrayList<>();
        list.addAll(oriList);
        if (list.isEmpty()) {
            set.add(sb.toString());
        } else {
            Integer in = list.remove(0);
            List<String> strs = map.get(in);
            for (String str :
                    strs) {
                StringBuffer stringBuffer = new StringBuffer(sb);
                stringBuffer.append(str);
                serach(stringBuffer, list);
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}