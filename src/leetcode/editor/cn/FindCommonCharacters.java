package leetcode.editor.cn;
//查找常用字符
//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 190 👎 0

import java.util.*;

public class FindCommonCharacters{
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        String[] arr = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        solution.commonChars(arr);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int j=0;j<A.length;j++) {
            String s = A[j];
            Map<Character, Integer> temp = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int n = temp.getOrDefault(chars[i], 0);
                temp.put(chars[i], n + 1);
            }
            if (!map.isEmpty()) {
                Iterator<Character> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    Character c = iterator.next();
                    if (!temp.keySet().contains(c)) {
                        iterator.remove();
                    }
                }
            }
            if (map.isEmpty()&&j==0) {
                for (char c : temp.keySet()) {
                    map.put(c, temp.get(c));
                }
            }else{
                for (char c : temp.keySet()) {
                    if (map.get(c) != null && map.get(c) > temp.get(c)) {
                        map.put(c, temp.get(c));
                    }
                }
            }
        }
        for (Map.Entry<Character, Integer> en :
                map.entrySet()) {
            if (en.getValue() > 1) {
                for (int i = 0; i < en.getValue(); i++) {
                    list.add(en.getKey().toString());
                }
            } else {
                list.add(en.getKey().toString());
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}