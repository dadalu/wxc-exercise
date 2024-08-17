package leetcode.editor.cn;
//重构字符串
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 286 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString{
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            charMap.put(S.charAt(i), charMap.getOrDefault(S.charAt(i), 0) + 1);
        }
        for (Integer i :
                charMap.values()) {
            if (i > (S.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue((o1,o2)->charMap.get(o2)-charMap.get(o1));
        for (Character c :
                charMap.keySet()) {
            queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size()>1) {
            Character c1 = queue.poll();
            Character c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            charMap.put(c1, charMap.get(c1) - 1);
            charMap.put(c2, charMap.get(c2) - 1);
            if (charMap.get(c1) > 0) {
                queue.offer(c1);
            }
            if (charMap.get(c2) > 0) {
                queue.offer(c2);
            }
        }
        if (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}